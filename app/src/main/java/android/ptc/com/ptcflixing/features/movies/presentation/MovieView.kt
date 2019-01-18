package android.ptc.com.ptcflixing.features.movies.presentation

import android.ptc.com.ptcflixing.features.movies.data.local.movies.MovieDto
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */
data class MovieView(
        val id: Long = 0,
        val title: String = "",
        val overview: String = "",
        val rating: Float = 0.0f,
        val year: Date?,
        val thumbnail: String = "",
        val poster: String = "",
        val genres: List<String>?
) {

    fun mapperToMovieDto(): MovieDto {

        return MovieDto(
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