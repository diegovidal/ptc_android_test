package android.ptc.com.ptcflixing.features.products

import android.ptc.com.ptcflixing.core.functional.Result
import android.ptc.com.ptcflixing.features.products.data.local.currentpage.CurrentPage
import android.ptc.com.ptcflixing.features.products.presentation.ProductDetailsView
import android.ptc.com.ptcflixing.features.products.presentation.ProductView

/**
 * @author diegovidal on 18/01/19.
 */

interface ProductsRepository {

    fun fetchProducts(): Result<List<ProductView>>

    fun addProducts(list: List<ProductView>): Result<Unit>

    fun clearProducts(): Result<Unit>

    fun fetchCurrentPage(): Result<CurrentPage?>

    fun incrementCurrentPage(): Result<Unit>

    fun fetchProductDetails(movieId: Long): Result<ProductDetailsView?>

    fun addProductDetails(productDetailsView: ProductDetailsView): Result<Long>

    fun refreshProducts(): Result<List<ProductView>>
}