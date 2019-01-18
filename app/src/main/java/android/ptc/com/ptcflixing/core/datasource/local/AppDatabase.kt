package android.ptc.com.ptcflixing.core.datasource.local

import android.ptc.com.ptcflixing.features.products.data.local.ProductDto
import android.ptc.com.ptcflixing.features.products.data.local.ProductsDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author diegovidal on 18/01/19.
 */

@Database(entities = [
    ProductDto::class
], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productsDao(): ProductsDao
}