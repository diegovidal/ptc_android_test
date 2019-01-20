package dvidal.com.productschallenge.features.splash

import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import dvidal.com.productschallenge.features.splash.data.local.ConfigLocalDataSource
import dvidal.com.productschallenge.features.splash.data.remote.ConfigRemoteDataSource
import dvidal.com.productschallenge.features.splash.presentation.ConfigView
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author diegovidal on 19/01/19.
 */

@Singleton
class ConfigRepositoryImpl @Inject constructor(
    private val localDataSource: ConfigLocalDataSource,
    private val remoteDataSource: ConfigRemoteDataSource,
    private val generalPreferencesManager: GeneralPreferencesManager
): ConfigRepository {

    override fun fetchConfig(): EitherResult<ConfigView?> {

        return if (localDataSource.fetchConfig().rightOrNull() == null) {

            remoteDataSource.fetchConfig().apply {
                localDataSource.addConfig(this.rightOrNull()?.mapperToConfigDto())
                generalPreferencesManager.saveCurrencySymbol(this.rightOrNull()?.currencySymbol ?: "")
            }

        } else localDataSource.fetchConfig()
    }

    override fun addConfig(configDto: ConfigDto?): EitherResult<Long> {

        return localDataSource.addConfig(configDto)
    }

    override fun clearConfig(): EitherResult<Unit> {

        return localDataSource.clearConfig()
    }
}