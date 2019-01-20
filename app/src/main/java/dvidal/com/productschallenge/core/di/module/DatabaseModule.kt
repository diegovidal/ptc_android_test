package dvidal.com.productschallenge.core.di.module

import android.content.Context
import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author diegovidal on 18/12/18.
 */

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {

        return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, DB_NAME).build()
    }

    companion object {

        private const val DB_NAME = "productschallenge_db"
    }
}