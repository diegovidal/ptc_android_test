package dvidal.com.productschallenge.features.products.presentation.details

import androidx.lifecycle.MutableLiveData
import dvidal.com.productschallenge.core.platform.BaseViewModel
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

    var images = MutableLiveData<List<String>>()

    fun loadProductDetails(productId: Long) {

        fetchProductDetailsUseCase.invoke(productId, Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadProductDetails)
        }
    }

    private fun handleLoadProductDetails(productDetailsView: ProductDetailsView?) {
        images.postValue(productDetailsView?.images)
    }
}