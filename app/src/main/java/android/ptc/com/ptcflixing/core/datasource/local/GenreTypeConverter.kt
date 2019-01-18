package android.ptc.com.ptcflixing.core.datasource.local

import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types




/**
 * @author diegovidal on 18/01/19.
 */
class GenreTypeConverter {

    @TypeConverter
    fun fromStringList(list: List<GenreDto>): String {

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, GenreDto::class.java)
        val adapter = moshi.adapter<List<GenreDto>>(type)

        return adapter.toJson(list)
    }

    @TypeConverter
    fun toStringList(value: String): List<GenreDto>? {

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, GenreDto::class.java)
        val adapter = moshi.adapter<List<GenreDto>>(type)

        return adapter.fromJson(value)
    }
}