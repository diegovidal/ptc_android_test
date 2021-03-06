package dvidal.com.productschallenge.features.splash.data.local

import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.utils.ConfigDataFactory
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.internal.DoNotInstrument

/**
 * @author diegovidal on 19/01/19.
 */

@RunWith(RobolectricTestRunner::class)
class ConfigViewDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun `should fetch config and return data`() {

        val config = ConfigDataFactory.makeConfigDto()
        database.configDao().addConfig(config)

        val testResult = database.configDao().fetchConfig()
        Assert.assertEquals(testResult, config)
    }

    @Test
    fun `should clear config and return empty`() {

        val config = ConfigDataFactory.makeConfigDto()
        database.configDao().addConfig(config)
        database.configDao().clearConfig()

        val testResult = database.configDao().fetchConfig()
        Assert.assertEquals(testResult, null)
    }
}