package android.ptc.com.ptcflixing.features.movies.data.local.movies

import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class MovieDto(
        @PrimaryKey val id: Long = 0,
        val title: String = "",
        val overview: String = "",
        val rating: Float = 0.0f,
        val year: Date?,
        val thumbnail: String = "",
        val poster: String = "",
        val genres: List<GenreDto>?
)