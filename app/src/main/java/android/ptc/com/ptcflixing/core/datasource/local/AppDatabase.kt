package android.ptc.com.ptcflixing.core.datasource.local

import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto
import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenresDao
import android.ptc.com.ptcflixing.features.movies.data.local.movies.MovieDto
import android.ptc.com.ptcflixing.features.movies.data.local.movies.MoviesDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author diegovidal on 18/01/19.
 */

@Database(entities = [
    MovieDto::class,
    GenreDto::class
], version = 1)
@TypeConverters(
        DateTypeConverter::class,
        GenreNameTypeConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
    abstract fun genresDao(): GenresDao
}