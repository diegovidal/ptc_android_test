package dvidal.com.productschallenge.features.splash

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.splash.data.local.ConfigLocalDataSource
import dvidal.com.productschallenge.features.splash.data.remote.ConfigRemoteDataSource
import dvidal.com.productschallenge.features.splash.data.remote.RemoteConfigResponse
import dvidal.com.productschallenge.utils.ConfigDataFactory
import dvidal.com.productschallenge.utils.TestUtils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * @author diegovidal on 20/01/19.
 */
class ConfigRepositoryTest {

    private var localDataSource = mock<ConfigLocalDataSource>()
    private var remoteDataSource = mock<ConfigRemoteDataSource>()
    private var generalPreferencesManager = mock<GeneralPreferencesManager>()

    private val localConfig = catching { ConfigDataFactory.makeConfigDto().mapperToConfigView() }
    private val remoteConfig = catching {  TestUtils.loadJson("mock/fetch_config", RemoteConfigResponse::class.java)?.mapperToConfigView() }

    private val repository: ConfigRepository = ConfigRepositoryImpl(
            localDataSource,
            remoteDataSource,
            generalPreferencesManager
    )

    @Before
    fun setUp() {
    }

    @Test
    fun `should fetch config from remote and return data`() {

        whenever(localDataSource.fetchConfig()).thenReturn(EitherResult.left(Throwable()))
        whenever(remoteDataSource.fetchConfig()).thenReturn(remoteConfig)

        val testResult = repository.fetchConfig()
        assertEquals(testResult, remoteConfig)
    }

    @Test
    fun `should fetch config from local and return data`() {

        whenever(localDataSource.fetchConfig()).thenReturn(localConfig)
        whenever(remoteDataSource.fetchConfig()).thenReturn(remoteConfig)

        val testResult = repository.fetchConfig()
        assertEquals(testResult, localConfig)
    }
}