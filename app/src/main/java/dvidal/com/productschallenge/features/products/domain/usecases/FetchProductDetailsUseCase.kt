package dvidal.com.productschallenge.features.products.domain.usecases

import dagger.Reusable
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */

@Reusable
class FetchProductDetailsUseCase @Inject constructor(
        private val repository: ProductsRepository
): UseCase<ProductDetailsView?, Long>() {

    override suspend fun run(params: Long) = repository.fetchProductDetails(params)

}