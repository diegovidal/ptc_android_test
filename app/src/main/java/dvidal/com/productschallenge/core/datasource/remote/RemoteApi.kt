package dvidal.com.productschallenge.core.datasource.remote

import dvidal.com.productschallenge.features.splash.data.remote.RemoteConfigResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author diegovidal on 19/01/19.
 */
interface RemoteApi {

    @GET("configurations/")
    fun fetchConfig(): Call<RemoteConfigResponse>
}