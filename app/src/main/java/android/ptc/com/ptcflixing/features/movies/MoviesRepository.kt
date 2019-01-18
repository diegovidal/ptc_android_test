package android.ptc.com.ptcflixing.features.movies

/**
 * @author diegovidal on 18/01/19.
 */

interface MoviesRepository {

    fun fetchMovies()

    fun addMovie()

    fun addGenre()

    fun fetchGenres()

    fun fetchMovieDetails(movieId: Long)

    fun addMovieDetails()

    fun searchMovies(query: String)

    fun refreshMovies()
}