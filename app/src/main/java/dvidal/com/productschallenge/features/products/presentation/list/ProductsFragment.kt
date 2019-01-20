package dvidal.com.productschallenge.features.products.presentation.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dvidal.com.productschallenge.AndroidApplication
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import dvidal.com.productschallenge.core.extension.failure
import dvidal.com.productschallenge.core.extension.observe
import dvidal.com.productschallenge.core.extension.observeEvent
import dvidal.com.productschallenge.core.platform.BaseFragment
import dvidal.com.productschallenge.features.products.presentation.ProductView
import dvidal.com.productschallenge.features.products.presentation.list.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_products.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * @author diegovidal on 18/01/19.
 */

class ProductsFragment : BaseFragment(), ProductsAdapter.ProductViewListener {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var adapter: ProductsAdapter

    override fun layoutRes() = R.layout.fragment_products

    private val viewModel by lazy {
        viewModelFactory.get<ProductsViewModel>(requireActivity())
    }

    override fun injectDagger() {
        (activity?.application as AndroidApplication).appComponent.activityComponent()
                .build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()

        viewModel?.let {
            observe(it.products, ::renderProducts)
            observeEvent(it.eventLoading, ::renderLoading)
            failure(it.failure, ::renderFailure)
        }.also { viewModel?.loadProducts() }

        srl_recycler_view.setOnRefreshListener { viewModel?.refreshProducts() }
    }

    private fun configureRecyclerView() {

        recycler_view?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter.configureListener(this)
        recycler_view?.adapter = adapter
    }

    private fun renderProducts(list: List<ProductView>) {

        adapter.updateData(list)
    }

    fun searchFor(text: String) {

        adapter.searchFor(text)
    }

    private fun renderLoading(loading: Boolean) {

        srl_recycler_view?.isRefreshing = loading
    }

    private fun renderFailure(failure: Throwable?) {

        tv_error?.visibility = View.VISIBLE
        Timber.e("error is $failure")
    }

    override fun onProductClicked(productView: ProductView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPagination() {
        viewModel?.loadProducts()
    }
}
