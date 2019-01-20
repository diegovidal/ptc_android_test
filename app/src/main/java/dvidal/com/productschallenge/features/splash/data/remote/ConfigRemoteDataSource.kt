package dvidal.com.productschallenge.features.splash.data.remote

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import javax.inject.Inject

/**
 * @author diegovidal on 19/01/19.
 */
class ConfigRemoteDataSource @Inject constructor(

): ConfigRepository {

    override fun fetchConfig(): EitherResult<ConfigDto?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addConfig(configDto: ConfigDto): EitherResult<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearConfig(): EitherResult<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}