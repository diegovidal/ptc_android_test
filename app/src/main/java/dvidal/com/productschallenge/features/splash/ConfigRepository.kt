package dvidal.com.productschallenge.features.splash

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import dvidal.com.productschallenge.features.splash.presentation.ConfigView

/**
 * @author diegovidal on 19/01/19.
 */
interface ConfigRepository {

    fun fetchConfig(): EitherResult<ConfigView?>

    fun addConfig(configDto: ConfigDto?): EitherResult<Long>

    fun clearConfig(): EitherResult<Unit>
}