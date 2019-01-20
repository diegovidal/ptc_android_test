package dvidal.com.productschallenge.features.products

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.products.data.cache.ProductsCacheDataSource
import dvidal.com.productschallenge.features.products.data.local.ProductsLocalDataSource
import dvidal.com.productschallenge.features.products.data.remote.ProductsRemoteDataSource
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */

class ProductsRepositoryImpl @Inject constructor(
        private val cacheDataSource: ProductsCacheDataSource,
        private val localDataSource: ProductsLocalDataSource,
        private val remoteDataSource: ProductsRemoteDataSource
): ProductsRepository {

    override fun fetchProducts(page: Int): EitherResult<List<ProductView>> {

        return if (localDataSource.fetchProducts(page).rightOrNull() == null) {

            remoteDataSource.fetchProducts(page).apply {
                localDataSource.addProducts(this.rightOrNull() ?: emptyList())
            }

        } else localDataSource.fetchProducts(page)
    }

    override fun addProducts(list: List<ProductView>): EitherResult<Unit> {

        return localDataSource.addProducts(list)
    }

    override fun clearProducts(): EitherResult<Unit> {

        return localDataSource.clearProducts()
    }

    override fun fetchCurrentPage(): EitherResult<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementCurrentPage(): EitherResult<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshProducts(): EitherResult<List<ProductView>> {

        localDataSource.clearProducts()
        return fetchProducts(page = 1)
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
}