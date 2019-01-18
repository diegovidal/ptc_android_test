package android.ptc.com.ptcflixing.core.di.module

import android.content.Context
import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
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

        private const val DB_NAME = "movieschallenge_db"
    }
}