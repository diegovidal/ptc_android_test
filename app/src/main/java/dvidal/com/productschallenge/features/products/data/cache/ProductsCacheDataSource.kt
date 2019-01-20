package dvidal.com.productschallenge.features.products.data.cache

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class ProductsCacheDataSource @Inject constructor()
    : ProductsRepository {
    
    private val cachedProductDetails = mutableMapOf<Long, ProductDetailsView>()

    override fun fetchProducts(): EitherResult<List<ProductView>> {

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

    override fun fetchCurrentPage(): EitherResult<Int> {

        throw UnsupportedOperationException("fetch current page isn't supported here...")
    }

    override fun incrementCurrentPage(): EitherResult<Unit> {

        throw UnsupportedOperationException("increment current page isn't supported here...")
    }

    override fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?> {

        if (cachedProductDetails.containsKey(productId)){
            return EitherResult.right(cachedProductDetails[productId])
        }

        return EitherResult.left(Throwable())
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): EitherResult<Long> {

        cachedProductDetails[productDetailsView.sku] = productDetailsView
        return EitherResult.right(productDetailsView.sku)
    }
}