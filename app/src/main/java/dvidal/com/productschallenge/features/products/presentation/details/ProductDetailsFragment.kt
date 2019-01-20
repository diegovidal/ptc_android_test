package dvidal.com.productschallenge.features.products.presentation.details


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.platform.BaseFragment
import timber.log.Timber


/**
 * @author diegovidal on 18/01/19.
 */
class ProductDetailsFragment : BaseFragment() {

    override fun layoutRes() = R.layout.fragment_product_details

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ProductDetailsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
