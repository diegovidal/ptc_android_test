package android.ptc.com.ptcflixing.core.datasource.local

import android.ptc.com.ptcflixing.features.products.data.local.currentpage.CurrentPage
import android.ptc.com.ptcflixing.features.products.data.local.currentpage.CurrentPageDao
import android.ptc.com.ptcflixing.features.products.data.local.movies.ProductDto
import android.ptc.com.ptcflixing.features.products.data.local.movies.ProductsDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author diegovidal on 18/01/19.
 */

@Database(entities = [
    ProductDto::class,
    CurrentPage::class
], version = 1)
@TypeConverters(
        DateTypeConverter::class,
        GenreNameTypeConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun moviesDao(): ProductsDao
    abstract fun genresDao(): CurrentPageDao
}