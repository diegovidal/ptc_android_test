package android.ptc.com.ptcflixing.features.movies.presentation

import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto

/**
 * @author diegovidal on 18/01/19.
 */

data class GenreView(
        val id: Long = 0,
        val name: String = ""
) {

    fun mapperToGenreDto(): GenreDto {

        return GenreDto(id, name)
    }
}