package dvidal.com.productschallenge.core.datasource.remote

import dvidal.com.productschallenge.features.products.data.remote.RemoteProductDetailsResponse
import dvidal.com.productschallenge.features.products.data.remote.RemoteProductResponse
import dvidal.com.productschallenge.features.splash.data.remote.RemoteConfigResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author diegovidal on 19/01/19.
 */
interface RemoteApi {

    @GET("configurations/")
    fun fetchConfig(): Call<RemoteConfigResponse>

    @GET("search/phone/page/{page}/")
    fun fetchProducts(@Path("page") page: Int): Call<RemoteProductResponse>

    @GET("product/{sku}/")
    fun fetchProductDetails(@Path("sku") sku: Long): Call<RemoteProductDetailsResponse>
}