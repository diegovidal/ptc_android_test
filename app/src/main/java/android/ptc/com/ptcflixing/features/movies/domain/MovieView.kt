package android.ptc.com.ptcflixing.features.movies.domain

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
)