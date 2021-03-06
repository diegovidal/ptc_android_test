package dvidal.com.productschallenge.core.platform

import dvidal.com.productschallenge.core.exception.RemoteFailure
import dvidal.com.productschallenge.core.functional.EitherResult
import retrofit2.Call

/**
 * @author diegovidal on 26/12/18.
 */
abstract class BaseRequester(
        private val networkHandler: NetworkHandler
) {

    fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): EitherResult<R> {
        return when (networkHandler.isConnected) {
            true -> requestHttp(call, transform, default)
            false, null -> EitherResult.left(RemoteFailure.NetworkConnection())
        }
    }

    private fun <T, R> requestHttp(call: Call<T>, transform: (T) -> R, default: T): EitherResult<R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> EitherResult.right(transform((response.body() ?: default)))
                false -> EitherResult.left(RemoteFailure.NetworkConnection())
            }
        } catch (exception: Throwable) {
            EitherResult.left(RemoteFailure.ServerError())
        }
    }
}