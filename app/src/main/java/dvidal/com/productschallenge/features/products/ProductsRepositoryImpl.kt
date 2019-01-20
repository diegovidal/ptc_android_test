package dvidal.com.productschallenge.features.products

import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.products.data.cache.ProductsCacheDataSource
import dvidal.com.productschallenge.features.products.data.local.ProductsLocalDataSource
import dvidal.com.productschallenge.features.products.data.remote.ProductsRemoteDataSource
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author diegovidal on 18/01/19.
 */
@Singleton
class ProductsRepositoryImpl @Inject constructor(
        private val cacheDataSource: ProductsCacheDataSource,
        private val localDataSource: ProductsLocalDataSource,
        private val remoteDataSource: ProductsRemoteDataSource,
        private val generalPreferencesManager: GeneralPreferencesManager
): ProductsRepository {

    override fun fetchProducts(page: Int): EitherResult<List<ProductView>> {

        var currentPage = generalPreferencesManager.getCurrentPage()
        val localResult = localDataSource.fetchProducts(currentPage).rightOrNull()
        val totalProducts = generalPreferencesManager.getTotalProducts()

        return if (localResult == null || localResult.isEmpty() || localResult.size < totalProducts) {

            currentPage += 1
            remoteDataSource.fetchProducts(currentPage).apply {
                localDataSource.addProducts(this.rightOrNull() ?: emptyList())
                generalPreferencesManager.incrementCurrentPage()
            }

        } else localDataSource.fetchProducts(currentPage)
    }

    override fun addProducts(list: List<ProductView>): EitherResult<Unit> {

        return localDataSource.addProducts(list)
    }

    override fun clearProducts(): EitherResult<Unit> {

        return localDataSource.clearProducts()
    }

    override fun refreshProducts(): EitherResult<List<ProductView>> {

        localDataSource.clearProducts()
        generalPreferencesManager.clearCurrentPage()
        return fetchProducts(page = FIRST_PAGE)
    }

    override fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?> {

        return if (!cacheDataSource.containsProductDetails(productId)){

            remoteDataSource.fetchProductDetails(productId).apply {
                cacheDataSource.addProductDetails(this.rightOrNull())
            }

        } else cacheDataSource.fetchProductDetails(productId)
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView?): EitherResult<Long> {

        return cacheDataSource.addProductDetails(productDetailsView)
    }

    companion object {

        const val FIRST_PAGE = 0
    }
}