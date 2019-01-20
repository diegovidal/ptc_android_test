package dvidal.com.productschallenge.features.products.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.core.platform.BaseViewModel
import dvidal.com.productschallenge.core.platform.MutableLiveEvent
import dvidal.com.productschallenge.core.platform.postEvent
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

    val products = MutableLiveData<List<ProductView>>()

    val eventLoading by lazy { MutableLiveEvent<Boolean>() }

    fun loadProducts() {

        eventLoading.postEvent(true)
        fetchProductsUseCase.invoke(1, Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadProducts)
        }
    }

    fun refreshProducts() = refreshProductsUseCase.invoke(UseCase.None(), Dispatchers.IO, job) {
        it.either(::handleFailure, ::handleRefreshProducts)
    }

    private fun handleLoadProducts(list: List<ProductView>) {

        eventLoading.postEvent(false)
        products.postValue(list)
    }

    private fun handleRefreshProducts(list: List<ProductView>) {

        eventLoading.postEvent(false)
        products.postValue(list)
    }
}