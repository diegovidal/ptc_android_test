package android.ptc.com.ptcflixing.core.datasource.local

import android.ptc.com.ptcflixing.features.products.data.local.ProductDto
import android.ptc.com.ptcflixing.features.products.data.local.ProductsDao
import android.ptc.com.ptcflixing.features.splash.data.local.ConfigDao
import android.ptc.com.ptcflixing.features.splash.data.local.ConfigDto
import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author diegovidal on 18/01/19.
 */

@Database(entities = [
    ProductDto::class,
    ConfigDto::class
], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productsDao(): ProductsDao
    abstract fun configDao(): ConfigDao
}