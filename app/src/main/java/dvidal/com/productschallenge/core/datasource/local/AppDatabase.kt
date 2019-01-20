package dvidal.com.productschallenge.core.datasource.local

import dvidal.com.productschallenge.features.products.data.local.ProductDto
import dvidal.com.productschallenge.features.products.data.local.ProductsDao
import dvidal.com.productschallenge.features.splash.data.local.ConfigDao
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
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