package android.ptc.com.ptcflixing.features.movies

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.movies.presentation.GenreView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieDetailsView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieView

/**
 * @author diegovidal on 18/01/19.
 */

class MoviesRepositoryImpl: MoviesRepository {

    override fun fetchMovies(): Result<List<MovieView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addMovies(list: List<MovieView>): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addGenres(list: List<GenreView>): Result<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchGenres(): Result<List<GenreView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchMovieDetails(movieId: Long): Result<MovieDetailsView?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addMovieDetails(movieDetailsView: MovieDetailsView): Result<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchMovies(query: String): Result<List<MovieView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshMovies(): Result<List<MovieView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}