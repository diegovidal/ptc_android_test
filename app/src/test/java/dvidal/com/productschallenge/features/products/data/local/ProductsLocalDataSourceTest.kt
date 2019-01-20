package dvidal.com.productschallenge.features.products.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.utils.ProductDataFactory
import dvidal.com.productschallenge.utils.ProductDetailsFactory
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/**
 * @author diegovidal on 19/01/19.
 */

@RunWith(RobolectricTestRunner::class)
class ProductsLocalDataSourceTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    private val localDataSource = ProductsLocalDataSource(database)

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun `should fetch products and return data`() {

        val product = ProductDataFactory.makeProductDto().mapperToMovieView()
        localDataSource.addProducts(listOf(product))

        val testResult = localDataSource.fetchProducts(0).rightOrNull()
        Assert.assertEquals(testResult, listOf(product))
    }

    @Test
    fun `should clear products and return empty`() {

        val product = ProductDataFactory.makeProductDto()
        localDataSource.addProducts(mutableListOf(product.mapperToMovieView()))
        localDataSource.clearProducts()

        val testResult = localDataSource.fetchProducts(0).rightOrNull()
        Assert.assertEquals(testResult, emptyList<ProductDto>())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `should refresh products and return throwable`() {

        localDataSource.refreshProducts()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `should fetch product details and return throwable`() {

        ProductDetailsFactory.makeProductDetails().also {
            localDataSource.addProductDetails(it)
        }
    }
}