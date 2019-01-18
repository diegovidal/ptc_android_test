package android.ptc.com.ptcflixing.features.products.data.local

import android.ptc.com.ptcflixing.core.datasource.local.AppDatabase
import android.ptc.com.ptcflixing.utils.ProductDataFactory
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

@DoNotInstrument
@RunWith(RobolectricTestRunner::class)
class ProductsDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.applicationContext,
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