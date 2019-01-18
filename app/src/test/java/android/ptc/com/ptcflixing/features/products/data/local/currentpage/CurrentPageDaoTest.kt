package android.ptc.com.ptcflixing.features.products.data.local.currentpage

import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import gizmin.com.br.bitfazpdv.core.util.DataFactory
import gizmin.com.br.bitfazpdv.core.util.GenreDataFactory
import org.junit.After
import org.junit.Assert.assertEquals
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
class CurrentPageDaoTest {

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
    fun `should fetch genres and return data`() {

        val genre = GenreDataFactory.makeGenreDto()
        database.genresDao().addGenre(genre)

        val testResult = database.genresDao().fetchCurrentPage()
        assertEquals(testResult, listOf(genre))
    }

    @Test
    fun `should clear genres and return empty`() {

        val genre = GenreDataFactory.makeGenreDto()
        database.genresDao().addGenre(genre)
        database.genresDao().clearGenres()

        val testResult = database.genresDao().fetchCurrentPage()
        assertEquals(testResult, emptyList<CurrentPage>())
    }

    @Test
    fun `should get genre and return the genre`() {

        val genre = GenreDataFactory.makeGenreDto()
        database.genresDao().addGenre(genre)

        val testResult = database.genresDao().getGenre(genreId = genre.id)
        assertEquals(genre, testResult)
    }

    @Test
    fun `should get customer and return null`() {

        val genre = GenreDataFactory.makeGenreDto()
        database.genresDao().addGenre(genre)

        val testResult = database.genresDao().getGenre(DataFactory.randomLong())
        assertEquals(testResult, null)
    }
}