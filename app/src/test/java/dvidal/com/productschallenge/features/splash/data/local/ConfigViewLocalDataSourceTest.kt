package dvidal.com.productschallenge.features.splash.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.utils.ConfigDataFactory
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment


/**
 * @author diegovidal on 19/01/19.
 */

@RunWith(RobolectricTestRunner::class)
class ConfigViewLocalDataSourceTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    private val configLocalDataSource = ConfigLocalDataSource(database)

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun `should fetch config and return data`() {

        val config = ConfigDataFactory.makeConfigDto()
        configLocalDataSource.addConfig(config)

        val testResult = configLocalDataSource.fetchConfig().rightOrNull()
        Assert.assertEquals(testResult, config.mapperToConfigView())
    }

    @Test
    fun `should clear config and return empty`() {

        val config = ConfigDataFactory.makeConfigDto()
        configLocalDataSource.addConfig(config)
        configLocalDataSource.clearConfig()

        val testResult = configLocalDataSource.fetchConfig().rightOrNull()
        Assert.assertEquals(testResult, null)
    }
}