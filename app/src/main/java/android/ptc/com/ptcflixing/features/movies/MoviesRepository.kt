package android.ptc.com.ptcflixing.features.movies

/**
 * @author diegovidal on 18/01/19.
 */

interface MoviesRepository {

    fun fetchMovies()

    fun fetchMovieDetails()

    fun searchMovies(query: String)

    fun refreshMovies()
}