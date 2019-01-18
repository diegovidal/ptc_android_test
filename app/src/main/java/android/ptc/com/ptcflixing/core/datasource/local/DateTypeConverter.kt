package android.ptc.com.ptcflixing.core.datasource.local

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author diegovidal on 18/01/19.
 */
class DateTypeConverter {

    @TypeConverter
    fun fromTimestamp(value: String): Date? {
        return SimpleDateFormat(DATE_FORMATTER, Locale.getDefault()).parse(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): String? {
        return SimpleDateFormat(DATE_FORMATTER, Locale.getDefault()).format(date)
    }

    companion object {

        const val DATE_FORMATTER = "yyyy-MM-dd"
    }
}