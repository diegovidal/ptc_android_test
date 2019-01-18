package android.ptc.com.ptcflixing.features.movies

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.movies.presentation.GenreView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieDetailsView
import android.ptc.com.ptcflixing.features.movies.presentation.MovieView

/**
 * @author diegovidal on 18/01/19.
 */

interface MoviesRepository {

    fun fetchMovies(): Result<List<MovieView>>

    fun addMovies(list: List<MovieView>): Result<Unit>

    fun addGenres(list: List<GenreView>): Result<Unit>

    fun fetchGenres(): Result<List<GenreView>>

    fun fetchMovieDetails(movieId: Long): Result<MovieDetailsView?>

    fun addMovieDetails(movieDetailsView: MovieDetailsView): Result<Long>

    fun searchMovies(query: String): Result<List<MovieView>>

    fun refreshMovies(): Result<List<MovieView>>
}