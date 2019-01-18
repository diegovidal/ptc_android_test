package gizmin.com.br.bitfazpdv.core.util

import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto

/**
 * @author diegovidal on 19/12/18.
 */
object GenreDataFactory {

    fun makeGenreDto(): GenreDto {

        return GenreDto(
                DataFactory.randomLong(), DataFactory.randomString()
        )
    }
}