package android.ptc.com.ptcflixing.features.movies.data.local.movies

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class MovieDto(
        @PrimaryKey val id: Long
)