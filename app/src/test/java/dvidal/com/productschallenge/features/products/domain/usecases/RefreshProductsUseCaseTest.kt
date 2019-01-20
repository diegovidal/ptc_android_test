package dvidal.com.productschallenge.features.products.domain.usecases

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import dvidal.com.productschallenge.core.functional.Either
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.utils.ProductDataFactory
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * @author diegovidal on 20/01/19.
 */
class RefreshProductsUseCaseTest {

    private val repository = mock<ProductsRepository>()
    private val useCase = RefreshProductsUseCase(repository)

    @Before
    fun setUp() {

        val product = ProductDataFactory.makeProductDto().mapperToMovieView()
        given { repository.refreshProducts() }.willReturn(Either.right(listOf(product)))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { useCase.run(UseCase.None()) }

        verify(repository).refreshProducts()
        verifyNoMoreInteractions(repository)
    }
}