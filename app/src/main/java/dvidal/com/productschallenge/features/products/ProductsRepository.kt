package dvidal.com.productschallenge.features.products

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView

/**
 * @author diegovidal on 18/01/19.
 */

interface ProductsRepository {

    fun fetchProducts(): EitherResult<List<ProductView>>

    fun addProducts(list: List<ProductView>): EitherResult<Unit>

    fun clearProducts(): EitherResult<Unit>

    fun refreshProducts(): EitherResult<List<ProductView>>

    fun fetchCurrentPage(): EitherResult<Int>

    fun incrementCurrentPage(): EitherResult<Unit>

    fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?>

    fun addProductDetails(productDetailsView: ProductDetailsView): EitherResult<Long>
}