package android.ptc.com.ptcflixing.features.products.data.local.movies

import android.ptc.com.ptcflixing.features.products.presentation.ProductView
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class ProductDto(
        @PrimaryKey val id: Long = 0,
        val title: String = "",
        val overview: String = "",
        val rating: Float = 0.0f,
        val year: Date?,
        val thumbnail: String = "",
        val poster: String = "",
        val genres: List<String>?
) {

    fun mapperToMovieView(): ProductView {

        return ProductView(
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