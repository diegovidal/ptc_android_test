package dvidal.com.productschallenge.features.products.presentation.details


import android.os.Bundle
import android.view.View
import dvidal.com.productschallenge.AndroidApplication
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import dvidal.com.productschallenge.core.platform.BaseFragment
import javax.inject.Inject


/**
 * @author diegovidal on 18/01/19.
 */
class ProductDetailsFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

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
    }
}
