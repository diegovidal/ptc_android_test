package android.ptc.com.ptcflixing.core.datasource.local

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author diegovidal on 18/01/19.
 */
class DateTypeConverter {

    @TypeConverter
    fun timestampToDate(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}