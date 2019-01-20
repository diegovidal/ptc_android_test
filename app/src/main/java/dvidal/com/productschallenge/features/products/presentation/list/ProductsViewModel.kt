package dvidal.com.productschallenge.features.products.presentation.list

import androidx.lifecycle.MutableLiveData
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.core.platform.BaseViewModel
import dvidal.com.productschallenge.features.products.domain.usecases.FetchProductsUseCase
import dvidal.com.productschallenge.features.products.domain.usecases.RefreshProductsUseCase
import dvidal.com.productschallenge.features.products.presentation.ProductView
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */
class ProductsViewModel @Inject constructor(
        private val fetchProductsUseCase: FetchProductsUseCase,
        private val refreshProductsUseCase: RefreshProductsUseCase
): BaseViewModel() {

    var products = MutableLiveData<List<ProductView>>()

    fun loadProducts() {

        val page = 1
        fetchProductsUseCase.invoke(page, Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadProducts)
        }
    }

    fun refreshProducts() = refreshProductsUseCase.invoke(UseCase.None(), Dispatchers.IO, job) {
        it.either(::handleFailure, ::handleRefreshProducts)
    }

    private fun handleLoadProducts(list: List<ProductView>) {
        products.postValue(list)
    }

    private fun handleRefreshProducts(list: List<ProductView>) {}
}