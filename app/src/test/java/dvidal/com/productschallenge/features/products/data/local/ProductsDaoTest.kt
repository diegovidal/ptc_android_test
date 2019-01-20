package dvidal.com.productschallenge.features.products.data.local

import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.utils.ProductDataFactory
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.internal.DoNotInstrument

/**
 * @author diegovidal on 18/01/19.
 */

@RunWith(RobolectricTestRunner::class)
class ProductsDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun `should fetch products and return data`() {

        val product = ProductDataFactory.makeProductDto()
        database.productsDao().addProduct(product)

        val testResult = database.productsDao().fetchProducts()
        Assert.assertEquals(testResult, listOf(product))
    }

    @Test
    fun `should clear products and return empty`() {

        val product = ProductDataFactory.makeProductDto()
        database.productsDao().addProduct(product)
        database.productsDao().clearProducts()

        val testResult = database.productsDao().fetchProducts()
        Assert.assertEquals(testResult, emptyList<ProductDto>())
    }
}