package dvidal.com.productschallenge.core.datasource.remote

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author diegovidal on 17/06/2018.
 */
class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response? {

        val modifiedRequest = chain.request()
                .newBuilder()
                .build()

        return chain.proceed(modifiedRequest)
    }
}