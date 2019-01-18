package android.ptc.com.ptcflixing.features.products.data.local

import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.core.functional.catching
import android.ptc.com.ptcflixing.features.products.ProductsRepository
import android.ptc.com.ptcflixing.features.products.presentation.ProductDetailsView
import android.ptc.com.ptcflixing.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class ProductsLocalDataSource @Inject constructor(
        private val appDatabase: AppDatabase
)
    : ProductsRepository {

    override fun fetchProducts(): Result<List<ProductView>> {

        return catching { appDatabase.productsDao().fetchProducts().map { it.mapperToMovieView() } }
    }

    override fun addProducts(list: List<ProductView>): Result<Unit> {

        return catching {
            list.forEach { movie -> appDatabase.productsDao().addProduct(movie.mapperToMovieDto()) }
        }
    }

    override fun clearProducts(): Result<Unit> {

        return catching { appDatabase.productsDao().clearProducts() }
    }

    override fun fetchCurrentPage(): Result<Int> {

        throw UnsupportedOperationException("Fetch current page isn't supported here...")
    }

    override fun incrementCurrentPage(): Result<Unit> {

        throw UnsupportedOperationException("increment current page isn't supported here...")
    }

    override fun refreshProducts(): Result<List<ProductView>> {

        throw UnsupportedOperationException("refresh products isn't supported here...")
    }

    override fun fetchProductDetails(movieId: Long): Result<ProductDetailsView?> {

        throw UnsupportedOperationException("Fetch product details isn't supported here...")
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): Result<Long> {

        throw UnsupportedOperationException("add product details isn't supported here...")
    }
}