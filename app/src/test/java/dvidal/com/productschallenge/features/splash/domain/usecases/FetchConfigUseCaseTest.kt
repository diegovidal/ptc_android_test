package dvidal.com.productschallenge.features.splash.domain.usecases

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import dvidal.com.productschallenge.core.functional.Either
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.utils.ConfigDataFactory
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * @author diegovidal on 20/01/19.
 */
class FetchConfigUseCaseTest() {

    private val repository = mock<ConfigRepository>()

    private val useCase = FetchConfigUseCase(repository)

    @Before
    fun setUp() {

        val config = ConfigDataFactory.makeConfigDto()
        given { repository.fetchConfig() }.willReturn(Either.right(config.mapperToConfigView()))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { useCase.run(UseCase.None()) }

        verify(repository).fetchConfig()
        verifyNoMoreInteractions(repository)
    }
}