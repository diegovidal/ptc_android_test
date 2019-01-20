package dvidal.com.productschallenge.features.products.presentation.details

import androidx.lifecycle.MutableLiveData
import dvidal.com.productschallenge.core.platform.BaseViewModel
import dvidal.com.productschallenge.core.platform.MutableLiveEvent
import dvidal.com.productschallenge.core.platform.postEvent
import dvidal.com.productschallenge.features.products.domain.usecases.FetchProductDetailsUseCase
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class ProductDetailsViewModel @Inject constructor(
        private val fetchProductDetailsUseCase: FetchProductDetailsUseCase

): BaseViewModel() {

    val productDetails by lazy { MutableLiveEvent<ProductDetailsView>() }
    val eventImagesFinished by lazy { MutableLiveEvent<List<String>>() }
    val eventLoading by lazy { MutableLiveEvent<Boolean>() }

    fun loadProductDetails(productId: Long) {

        eventLoading.postEvent(true)
        fetchProductDetailsUseCase.invoke(productId, Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadProductDetails)
        }
    }

    private fun handleLoadProductDetails(productDetailsView: ProductDetailsView?) {

        eventLoading.postEvent(false)
        productDetails.postEvent(productDetailsView)
        eventImagesFinished.postEvent(productDetailsView?.images)
    }

    override fun handleFailure(failure: Throwable) {
        super.handleFailure(failure)
        eventLoading.postEvent(false)
    }
}