package android.ptc.com.ptcflixing.features.movies.data.local.movies

import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
import android.ptc.com.ptcflixing.features.movies.data.local.genres.GenreDto
import android.ptc.com.ptcflixing.utils.MovieDataFactory
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import gizmin.com.br.bitfazpdv.core.util.DataFactory
import gizmin.com.br.bitfazpdv.core.util.GenreDataFactory
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.internal.DoNotInstrument

/**
 * @author diegovidal on 18/01/19.
 */

@DoNotInstrument
@RunWith(RobolectricTestRunner::class)
class MoviesDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.applicationContext,
            AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun `should fetch movies and return data`() {

        val genres = listOf(GenreDataFactory.makeGenreDto().name, GenreDataFactory.makeGenreDto().name)
        val movie = MovieDataFactory.makeMovieDto(genres)
        database.moviesDao().addMovie(movie)

        val testResult = database.moviesDao().fetchMovies()
        Assert.assertEquals(testResult, listOf(movie))
    }

    @Test
    fun `should clear movies and return empty`() {

        val genres = listOf(GenreDataFactory.makeGenreDto().name, GenreDataFactory.makeGenreDto().name)
        val movie = MovieDataFactory.makeMovieDto(genres)
        database.moviesDao().addMovie(movie)
        database.moviesDao().clearMovies()

        val testResult = database.moviesDao().fetchMovies()
        Assert.assertEquals(testResult, emptyList<MovieDto>())
    }
}