package android.ptc.com.ptcflixing.features.movies.data.cache

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.movies.MoviesRepository
import android.ptc.com.ptcflixing.features.movies.presentation.GenreView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieDetailsView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class MoviesCacheDataSource @Inject constructor()
    : MoviesRepository {

    private val cachedSearchMovies = mutableListOf<MovieView>()
    private val cachedMovieDetails = mutableMapOf<Long, MovieDetailsView>()

    override fun fetchMovies(): Result<List<MovieView>> {

        throw UnsupportedOperationException("fetch movies isn't supported here...")
    }

    override fun addMovies(list: List<MovieView>): Result<Unit> {

        cachedSearchMovies.clear()
        cachedSearchMovies.addAll(list)

        return Result.right(Unit)
    }

    override fun addGenres(list: List<GenreView>): Result<Unit> {

        throw UnsupportedOperationException("Add genres isn't supported here...")
    }

    override fun fetchGenres(): Result<List<GenreView>> {

        throw UnsupportedOperationException("fetch genres isn't supported here...")
    }

    override fun fetchMovieDetails(movieId: Long): Result<MovieDetailsView?> {

        if (cachedMovieDetails.containsKey(movieId)){
            return Result.right(cachedMovieDetails[movieId])
        }

        return Result.left(Throwable())
    }

    override fun addMovieDetails(movieDetailsView: MovieDetailsView): Result<Long> {

        cachedMovieDetails[movieDetailsView.id] = movieDetailsView
        return Result.right(movieDetailsView.id)
    }

    override fun searchMovies(query: String): Result<List<MovieView>> {

        return Result.right(cachedSearchMovies)
    }

    override fun refreshMovies(): Result<List<MovieView>> {

        throw UnsupportedOperationException("refresh movies isn't supported here...")
    }
}