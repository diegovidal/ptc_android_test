package dvidal.com.productschallenge.features.products.presentation.details


import android.os.Bundle
import android.view.View
import dvidal.com.productschallenge.AndroidApplication
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import dvidal.com.productschallenge.core.extension.failure
import dvidal.com.productschallenge.core.extension.observe
import dvidal.com.productschallenge.core.extension.observeEvent
import dvidal.com.productschallenge.core.platform.BaseFragment
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.details.adapter.ProductDetailsImageAdapter
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.fragment_products.*
import timber.log.Timber
import javax.inject.Inject


/**
 * @author diegovidal on 18/01/19.
 */
class ProductDetailsFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var adapter: ProductDetailsImageAdapter

    override fun layoutRes() = R.layout.fragment_product_details

    private val viewModel by lazy {
        viewModelFactory.get<ProductDetailsViewModel>(requireActivity())
    }

    override fun injectDagger() {
        (activity?.application as AndroidApplication).appComponent.activityComponent()
                .build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = (activity as ProductDetailsActivity).productId
        vp_product_images.adapter = adapter
        ci_product_images.setViewPager(vp_product_images)

        viewModel?.let {
            observe(it.productDetails, ::renderProductDetails)
            observeEvent(it.eventImagesFinished, ::renderImages)
            failure(it.failure, ::renderFailure)
        }.also { viewModel?.loadProductDetails(productId) }
    }

    private fun renderProductDetails(productDetailsView: ProductDetailsView) {

        tv_product_special_price.text = productDetailsView.specialPrice.toString()
        tv_product_price.text = productDetailsView.price.toString()
        rb_product.rating = productDetailsView.rating?.toFloat() ?: 0f
        tv_product_specification.text = productDetailsView.description
    }

    private fun renderImages(list: List<String>) {

        adapter.updateData(list)
    }

    private fun renderFailure(failure: Throwable?) {

//        tv_error?.visibility = View.VISIBLE
        Timber.e("error is $failure")
    }
}
