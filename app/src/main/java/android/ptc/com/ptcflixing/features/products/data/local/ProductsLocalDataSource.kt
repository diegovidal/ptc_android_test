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

        return catching { appDatabase.moviesDao().fetchProducts().map { it.mapperToMovieView() } }
    }

    override fun addProducts(list: List<ProductView>): Result<Unit> {

        return catching {
            list.forEach { movie -> appDatabase.moviesDao().addProduct(movie.mapperToMovieDto()) }
        }
    }

    override fun clearProducts(): Result<Unit> {

        return catching { appDatabase.moviesDao().clearProducts() }
    }

    override fun addGenres(list: List<GenreView>): Result<Unit> {

        return catching {
            list.forEach { genre -> appDatabase.genresDao().addGenre(genre.mapperToGenreDto()) }
        }
    }

    override fun fetchCurrentPage(): Result<List<GenreView>> {

        return catching { appDatabase.genresDao().fetchCurrentPage().map { it.mapperToGenreView() } }
    }

    override fun fetchProductDetails(movieId: Long): Result<ProductDetailsView?> {

        throw UnsupportedOperationException("Fetch movie details isn't supported here...")
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): Result<Long> {

        throw UnsupportedOperationException("add movie details isn't supported here...")
    }

    override fun searchMovies(query: String): Result<List<ProductView>> {

        throw UnsupportedOperationException("search movies isn't supported here...")
    }

    override fun refreshMovies(): Result<List<ProductView>> {

        throw UnsupportedOperationException("refresh movies isn't supported here...")
    }
}