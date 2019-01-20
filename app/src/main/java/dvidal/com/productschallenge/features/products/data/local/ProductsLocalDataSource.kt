package dvidal.com.productschallenge.features.products.data.local

import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class ProductsLocalDataSource @Inject constructor(
        private val appDatabase: AppDatabase
) : ProductsRepository {

    override fun fetchProducts(): EitherResult<List<ProductView>> {

        return catching { appDatabase.productsDao().fetchProducts().map { it.mapperToMovieView() } }
    }

    override fun addProducts(list: List<ProductView>): EitherResult<Unit> {

        return catching {
            list.forEach { product -> appDatabase.productsDao().addProduct(product.mapperToMovieDto()) }
        }
    }

    override fun clearProducts(): EitherResult<Unit> {

        return catching { appDatabase.productsDao().clearProducts() }
    }

    override fun refreshProducts(): EitherResult<List<ProductView>> {

        throw UnsupportedOperationException("refresh products isn't supported here...")
    }

    override fun fetchCurrentPage(): EitherResult<Int> {

        throw UnsupportedOperationException("Fetch current page isn't supported here...")
    }

    override fun incrementCurrentPage(): EitherResult<Unit> {

        throw UnsupportedOperationException("increment current page isn't supported here...")
    }

    override fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?> {

        throw UnsupportedOperationException("Fetch product details isn't supported here...")
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): EitherResult<Long> {

        throw UnsupportedOperationException("add product details isn't supported here...")
    }
}