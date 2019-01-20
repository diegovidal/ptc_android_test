package dvidal.com.productschallenge.features.products

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.features.products.presentation.ProductView

/**
 * @author diegovidal on 18/01/19.
 */

class ProductsRepositoryImpl: ProductsRepository {

    override fun fetchProducts(): EitherResult<List<ProductView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addProducts(list: List<ProductView>): EitherResult<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearProducts(): EitherResult<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchCurrentPage(): EitherResult<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun incrementCurrentPage(): EitherResult<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshProducts(): EitherResult<List<ProductView>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchProductDetails(productId: Long): EitherResult<ProductDetailsView?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addProductDetails(productDetailsView: ProductDetailsView): EitherResult<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}