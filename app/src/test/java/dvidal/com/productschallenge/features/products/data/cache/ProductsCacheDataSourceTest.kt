package dvidal.com.productschallenge.features.products.data.cache

import dvidal.com.productschallenge.utils.ProductDetailsFactory
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author diegovidal on 19/01/19.
 */

class ProductsCacheDataSourceTest {

    private val cacheDataSource = ProductsCacheDataSource()

    @Test(expected = UnsupportedOperationException::class)
    fun `should fetch products and return throwable`() {

        cacheDataSource.fetchProducts(0)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `should add products and return throwable`() {

        cacheDataSource.addProducts(emptyList())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `should clear products and return throwable`() {

        cacheDataSource.clearProducts()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `should refresh products and return throwable`() {

        cacheDataSource.refreshProducts()
    }

    @Test
    fun `should fetch product details and return data`() {

        val productDetails = ProductDetailsFactory.makeProductDetails()
        cacheDataSource.addProductDetails(productDetails)

        val testResult = cacheDataSource.fetchProductDetails(productDetails.sku).rightOrNull()
        assertEquals(testResult, productDetails)
    }

}