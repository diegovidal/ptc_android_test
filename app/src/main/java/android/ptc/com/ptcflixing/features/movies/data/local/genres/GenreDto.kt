package android.ptc.com.ptcflixing.features.movies.data.local.genres

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class GenreDto(
        @PrimaryKey val id: Long = 0,
        val name: String = ""
)