package android.ptc.com.ptcflixing.features.products.presentation

import android.ptc.com.ptcflixing.features.products.data.local.movies.ProductDto
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */
data class ProductView(
        val id: Long = 0,
        val title: String = "",
        val overview: String = "",
        val rating: Float = 0.0f,
        val year: Date?,
        val thumbnail: String = "",
        val poster: String = "",
        val genres: List<String>?
) {

    fun mapperToMovieDto(): ProductDto {

        return ProductDto(
                id = id,
                title = title,
                overview = overview,
                rating = rating,
                year = year,
                thumbnail = thumbnail,
                poster = poster,
                genres = genres
        )
    }
}