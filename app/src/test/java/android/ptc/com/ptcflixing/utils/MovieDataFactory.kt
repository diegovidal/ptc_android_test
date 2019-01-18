package android.ptc.com.ptcflixing.utils

import android.ptc.com.ptcflixing.features.products.data.local.movies.ProductDto
import gizmin.com.br.bitfazpdv.core.util.DataFactory
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */

object MovieDataFactory {

    fun makeMovieDto(genres: List<String>): ProductDto {

        return ProductDto(
                id = DataFactory.randomLong(),
                title = DataFactory.randomString(),
                overview = DataFactory.randomString(),
                rating = DataFactory.randomFloat(),
                year = Date(),
                thumbnail = DataFactory.randomString(),
                poster = DataFactory.randomString(),
                genres = genres
        )
    }
}