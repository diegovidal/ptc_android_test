package dvidal.com.productschallenge.core.exception

/**
 * @author diegovidal on 26/12/18.
 */
sealed class RemoteFailure {

    class NetworkConnection : Throwable()
    class ServerError : Throwable()

    class FetchPostalCodeFailure : Throwable()
    class InsertCustomerFailure : Throwable()
}