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

    val productDetails by lazy { MutableLiveData<ProductDetailsView>() }
    val eventImagesFinished by lazy { MutableLiveEvent<List<String>>() }

    fun loadProductDetails(productId: Long) {

        fetchProductDetailsUseCase.invoke(productId, Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadProductDetails)
        }
    }

    private fun handleLoadProductDetails(productDetailsView: ProductDetailsView?) {

        productDetails.postValue(productDetailsView)
        eventImagesFinished.postEvent(productDetailsView?.images)
    }
}