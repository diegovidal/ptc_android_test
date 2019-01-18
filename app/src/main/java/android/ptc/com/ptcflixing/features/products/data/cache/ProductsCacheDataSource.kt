package android.ptc.com.ptcflixing.features.products.data.cache

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.products.ProductsRepository
import android.ptc.com.ptcflixing.features.products.presentation.ProductDetailsView
import android.ptc.com.ptcflixing.features.products.presentation.ProductView
import javax.inject.Inject

/**
 * @author diegovidal on 18/01/19.
 */
class ProductsCacheDataSource @Inject constructor()
    : ProductsRepository {
    
    private val cachedProductDetails = mutableMapOf<Long, ProductDetailsView>()

    override fun fetchProducts(): Result<List<ProductView>> {

        throw UnsupportedOperationException("fetch products isn't supported here...")
    }

    override fun addProducts(list: List<ProductView>): Result<Unit> {

        throw UnsupportedOperationException("add products isn't supported here...")
    }

    override fun clearProducts(): Result<Unit> {

        throw UnsupportedOperationException("clear products isn't supported here...")
    }

    override fun fetchCurrentPage(): Result<Int> {

        throw UnsupportedOperationException("fetch current page isn't supported here...")
    }

    override fun fetchProductDetails(movieId: Long): Result<ProductDetailsView?> {

        if (cachedProductDetails.containsKey(movieId)){
            return Result.right(cachedProductDetails[movieId])
        }

        return Result.left(Throwable())
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): Result<Long> {

        cachedProductDetails[productDetailsView.sku] = productDetailsView
        return Result.right(productDetailsView.sku)
    }

    override fun incrementCurrentPage(): Result<Unit> {

        throw UnsupportedOperationException("increment current page isn't supported here...")
    }

    override fun refreshProducts(): Result<List<ProductView>> {

        throw UnsupportedOperationException("refresh products isn't supported here...")
    }
}