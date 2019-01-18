package android.ptc.com.ptcflixing.features.movies.data.local.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author diegovidal on 18/01/19.
 */

@Dao
interface MoviesDao {

    @Query("SELECT * FROM moviedto")
    fun fetchMovies(): List<MovieDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieDto: MovieDto): Long

    @Query("DELETE FROM moviedto")
    fun clearMovies()
}