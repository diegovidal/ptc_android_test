package android.ptc.com.ptcflixing.features.movies.data.local.genres

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * @author diegovidal on 18/01/19.
 */

@Dao
interface GenresDao {

    @Query("SELECT * FROM genredto")
    fun fetchGenres(): List<GenreDto>

    @Query("SELECT * FROM genredto WHERE id = :genreId")
    fun getGenre(genreId: Long): GenreDto?

    @Insert(onConflict = REPLACE)
    fun addGenre(genreDto: GenreDto): Long

    @Query("DELETE FROM genredto")
    fun clearGenres()
}