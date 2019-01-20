package dvidal.com.productschallenge.features.products.data.cache

import dagger.Reusable
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */

@Reusable
class ProductsCacheDataSource @Inject constructor()
    : ProductsRepository {
    
    private val cachedProductDetails = mutableMapOf<Long, ProductDetailsView>()

    override fun fetchProducts(page: Int): EitherResult<List<ProductView>> {

        throw UnsupportedOperationException("fetch products isn't supported here...")
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

        if (cachedProductDetails.containsKey(productId)){
            return catching { cachedProductDetails[productId] }
        }

        return EitherResult.left(Throwable())
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView?): EitherResult<Long> {

        return catching {
            productDetailsView?.let { cachedProductDetails[productDetailsView.sku] = productDetailsView }
            productDetailsView?.sku ?: -1
        }
    }

    fun containsProductDetails(productId: Long): Boolean {

        return cachedProductDetails.containsKey(productId)
    }
}