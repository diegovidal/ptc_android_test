package dvidal.com.productschallenge.features.products.presentation.list

import android.os.Bundle
import dvidal.com.productschallenge.R
import android.view.View
import dvidal.com.productschallenge.core.platform.BaseFragment
import timber.log.Timber

/**
 * @author diegovidal on 18/01/19.
 */

class ProductsFragment : BaseFragment() {

    override fun layoutRes() = R.layout.fragment_products

    private val viewModel by lazy {
//        viewModelFactory.get<ProductsViewModel>(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("Tanto faz")
    }
}
