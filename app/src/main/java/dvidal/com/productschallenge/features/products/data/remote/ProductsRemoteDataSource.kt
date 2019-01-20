package dvidal.com.productschallenge.features.products.data.remote

import dagger.Reusable
import dvidal.com.productschallenge.core.datasource.remote.RemoteApi
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.platform.BaseRequester
import dvidal.com.productschallenge.core.platform.NetworkHandler
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */

@Reusable
class ProductsRemoteDataSource @Inject constructor(
        private val service: RemoteApi,
        networkHandler: NetworkHandler
): BaseRequester(networkHandler), ProductsRepository {

    override fun fetchProducts(page: Int): EitherResult<List<ProductView>> {

        return request( service.fetchProducts(page), {response ->
            response.data.results.map { it.mapperToProductView() }}, RemoteProductResponse.empty())
    }

    override fun addProducts(list: List<ProductView>): EitherResult<Unit> {

        throw UnsupportedOperationException("add products isn't supported here...")
    }

    override fun clearProducts(): EitherResult<Unit> {

        throw UnsupportedOperationException("clear products isn't supported here...")
    }

    override fun refreshProducts(): EitherResult<List<ProductView>> {

        throw UnsupportedOperationException("refresh products isn't supported here...")
    }

    override fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?> {

        return request( service.fetchProductDetails(productId), {it.mapperToProductDetailsView()},
                RemoteProductDetailsResponse.empty() )
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView?): EitherResult<Long> {

        throw UnsupportedOperationException("add product details isn't supported here...")
    }
}