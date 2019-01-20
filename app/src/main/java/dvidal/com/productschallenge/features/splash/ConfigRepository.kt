package dvidal.com.productschallenge.features.splash

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto

/**
 * @author diegovidal on 19/01/19.
 */
interface ConfigRepository {

    fun fetchConfig(): EitherResult<ConfigView?>

    fun addConfig(configDto: ConfigDto?): EitherResult<Long>

    fun clearConfig(): EitherResult<Unit>
}