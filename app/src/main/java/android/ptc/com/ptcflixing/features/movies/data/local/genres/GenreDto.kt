package android.ptc.com.ptcflixing.features.movies.data.local.genres

import android.ptc.com.ptcflixing.features.movies.presentation.GenreView
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class GenreDto(
        @PrimaryKey val id: Long = 0,
        val name: String = ""
) {

    fun mapperToGenreView(): GenreView {

        return GenreView(id, name)
    }
}