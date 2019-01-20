package dvidal.com.productschallenge.core.platform

import android.content.Context
import dvidal.com.productschallenge.core.extension.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author diegovidal on 26/12/18.
 */

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting
}