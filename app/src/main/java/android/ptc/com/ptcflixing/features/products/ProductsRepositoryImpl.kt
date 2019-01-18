package android.ptc.com.ptcflixing.features.products

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.products.presentation.ProductDetailsView
import android.ptc.com.ptcflixing.features.products.presentation.ProductView

/**
 * @author diegovidal on 18/01/19.
 */

class ProductsRepositoryImpl: ProductsRepository {

    override fun fetchProducts(): Result<List<ProductView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addProducts(list: List<ProductView>): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearProducts(): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addGenres(list: List<GenreView>): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchCurrentPage(): Result<List<GenreView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchProductDetails(movieId: Long): Result<ProductDetailsView?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): Result<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchMovies(query: String): Result<List<ProductView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshMovies(): Result<List<ProductView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}