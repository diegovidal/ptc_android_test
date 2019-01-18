package android.ptc.com.ptcflixing.core.datasource.local

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


/**
 * @author diegovidal on 18/01/19.
 */
class GenreNameTypeConverter {

    @TypeConverter
    fun fromStringList(list: List<String>): String {

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)

        return adapter.toJson(list)
    }

    @TypeConverter
    fun toStringList(value: String): List<String>? {

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)

        return adapter.fromJson(value)
    }
}