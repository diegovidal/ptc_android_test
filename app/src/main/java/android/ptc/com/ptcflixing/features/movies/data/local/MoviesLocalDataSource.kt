package android.ptc.com.ptcflixing.features.movies.data.local

import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.core.functional.catching
import android.ptc.com.ptcflixing.features.movies.MoviesRepository
import android.ptc.com.ptcflixing.features.movies.presentation.GenreView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieDetailsView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class MoviesLocalDataSource @Inject constructor(
        private val appDatabase: AppDatabase
)
    : MoviesRepository {

    override fun fetchMovies(): Result<List<MovieView>> {

        return catching { appDatabase.moviesDao().fetchMovies().map { it.mapperToMovieView() } }
    }

    override fun addMovies(list: List<MovieView>): Result<Unit> {

        return catching {
            list.forEach { movie -> appDatabase.moviesDao().addMovie(movie.mapperToMovieDto()) }
        }
    }

    override fun addGenres(list: List<GenreView>): Result<Unit> {

        return catching {
            list.forEach { genre -> appDatabase.genresDao().addGenre(genre.mapperToGenreDto()) }
        }
    }

    override fun fetchGenres(): Result<List<GenreView>> {

        return catching { appDatabase.genresDao().fetchGenres().map { it.mapperToGenreView() } }
    }

    override fun fetchMovieDetails(movieId: Long): Result<MovieDetailsView?> {

        throw UnsupportedOperationException("Fetch movie details isn't supported here...")
    }

    override fun addMovieDetails(movieDetailsView: MovieDetailsView): Result<Long> {

        throw UnsupportedOperationException("add movie details isn't supported here...")
    }

    override fun searchMovies(query: String): Result<List<MovieView>> {

        throw UnsupportedOperationException("search movies isn't supported here...")
    }

    override fun refreshMovies(): Result<List<MovieView>> {

        throw UnsupportedOperationException("refresh movies isn't supported here...")
    }
}