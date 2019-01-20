package dvidal.com.productschallenge.features.products

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.products.data.cache.ProductsCacheDataSource
import dvidal.com.productschallenge.features.products.data.local.ProductsLocalDataSource
import dvidal.com.productschallenge.features.products.data.remote.ProductsRemoteDataSource
import dvidal.com.productschallenge.features.products.data.remote.RemoteProductDetailsResponse
import dvidal.com.productschallenge.features.products.data.remote.RemoteProductResponse
import dvidal.com.productschallenge.features.splash.data.remote.RemoteConfigResponse
import dvidal.com.productschallenge.utils.ProductDataFactory
import dvidal.com.productschallenge.utils.ProductDetailsDataFactory
import dvidal.com.productschallenge.utils.TestUtils
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * @author diegovidal on 20/01/19.
 */
class ProductsRepositoryTest {

    private var cacheDataSource = mock<ProductsCacheDataSource>()
    private var localDataSource = mock<ProductsLocalDataSource>()
    private var remoteDataSource = mock<ProductsRemoteDataSource>()
    private var generalPreferencesManager = mock<GeneralPreferencesManager>()

    private val localFetchProducts = catching { listOf(ProductDataFactory.makeProductDto().mapperToMovieView()) }
    private val remoteFetchProducts = catching {  TestUtils.loadJson("mock/fetch_products", RemoteProductResponse::class.java)!!.data.
            results.map { it.mapperToProductView() } }

    private val cacheFetchProductDetails = catching { ProductDetailsDataFactory.makeProductDetails()}
    private val remoteFetchProductDetails = catching {  TestUtils.loadJson("mock/fetch_product_details",
            RemoteProductDetailsResponse::class.java)?.mapperToProductDetailsView() }

    private val repository: ProductsRepository = ProductsRepositoryImpl(
            cacheDataSource,
            localDataSource,
            remoteDataSource,
            generalPreferencesManager
    )

    @Before
    fun setUp() {

        whenever(generalPreferencesManager.incrementCurrentPage()).thenReturn(-1)
        whenever(generalPreferencesManager.getCurrentPage()).thenReturn(-1)
        whenever(generalPreferencesManager.getTotalProducts()).thenReturn(-1)
    }

    @Test
    fun `should fetch products from remote and return data`() {

        whenever(localDataSource.fetchProducts(-1)).thenReturn(EitherResult.left(Throwable()))
        whenever(remoteDataSource.fetchProducts(-1)).thenReturn(remoteFetchProducts )

//        val testResult = repository.fetchProducts(-1)
//        assertEquals(testResult, remoteFetchProducts)
    }

    @Test
    fun `should fetch products from local and return data`() {

        whenever(localDataSource.fetchProducts(-1)).thenReturn(localFetchProducts)
        whenever(remoteDataSource.fetchProducts(-1)).thenReturn(remoteFetchProducts)

        val testResult = repository.fetchProducts(-1)
        assertEquals(testResult, localFetchProducts)
    }

    @Test
    fun `should fetch product details from remote and return data`() {

        whenever(cacheDataSource.containsProductDetails(-1)).thenReturn(false)
        whenever(cacheDataSource.fetchProductDetails(-1)).thenReturn(cacheFetchProductDetails )
        whenever(remoteDataSource.fetchProductDetails(-1)).thenReturn(remoteFetchProductDetails )

        val testResult = repository.fetchProductDetails(-1)
        assertEquals(testResult, remoteFetchProductDetails)
    }

    @Test
    fun `should fetch product details from local and return data`() {

        whenever(cacheDataSource.containsProductDetails(-1)).thenReturn(true)
        whenever(cacheDataSource.fetchProductDetails(-1)).thenReturn(cacheFetchProductDetails )
        whenever(remoteDataSource.fetchProductDetails(-1)).thenReturn(remoteFetchProductDetails)

        val testResult = repository.fetchProductDetails(-1)
        assertEquals(testResult, cacheFetchProductDetails)
    }
}