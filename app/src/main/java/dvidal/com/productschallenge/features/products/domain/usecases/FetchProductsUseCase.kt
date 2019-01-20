package dvidal.com.productschallenge.features.products.domain.usecases

import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */
class FetchProductsUseCase @Inject constructor(
        private val repository: ProductsRepository
): UseCase<List<ProductView>, Int>() {

    override suspend fun run(params: Int) = repository.fetchProducts(params)
}