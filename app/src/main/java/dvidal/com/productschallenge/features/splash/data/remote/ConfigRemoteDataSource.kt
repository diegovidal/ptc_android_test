package dvidal.com.productschallenge.features.splash.data.remote

import dvidal.com.productschallenge.core.datasource.remote.RemoteApi
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.platform.BaseRequester
import dvidal.com.productschallenge.core.platform.NetworkHandler
import dvidal.com.productschallenge.features.splash.presentation.ConfigView
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import javax.inject.Inject

/**
 * @author diegovidal on 19/01/19.
 */
class ConfigRemoteDataSource @Inject constructor(
    private val service: RemoteApi,
    networkHandler: NetworkHandler
): BaseRequester(networkHandler), ConfigRepository {

    override fun fetchConfig(): EitherResult<ConfigView?> {

        return request(service.fetchConfig(), {it.mapperToConfigView()}, RemoteConfigResponse.empty())
    }

    override fun addConfig(configDto: ConfigDto?): EitherResult<Long> {

        throw UnsupportedOperationException("add config isn't supported here...")
    }

    override fun clearConfig(): EitherResult<Unit> {

        throw UnsupportedOperationException("clear config isn't supported here...")
    }
}