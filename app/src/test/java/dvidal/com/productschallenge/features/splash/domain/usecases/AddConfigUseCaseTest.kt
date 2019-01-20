package dvidal.com.productschallenge.features.splash.domain.usecases

import com.nhaarman.mockito_kotlin.*
import dvidal.com.productschallenge.core.functional.Either
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.utils.ConfigDataFactory
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * @author diegovidal on 20/01/19.
 */
class AddConfigUseCaseTest {

    private val repository = mock<ConfigRepository>()
    private val useCase = FetchConfigUseCase(repository)

    private val config = ConfigDataFactory.makeConfigDto()

    @Before
    fun setUp() {
        given { repository.addConfig(config) }.willReturn(Either.right(-1))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { useCase.run(UseCase.None()) }
    }
}