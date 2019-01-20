package dvidal.com.productschallenge.features.products.domain.usecases

import dagger.Reusable
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */

@Reusable
class RefreshProductsUseCase @Inject constructor(
        private val repository: ProductsRepository
): UseCase<List<ProductView>, UseCase.None>() {

    override suspend fun run(params: None) = repository.refreshProducts()
}