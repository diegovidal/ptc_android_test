package dvidal.com.productschallenge.features.splash.data.local

import dvidal.com.productschallenge.core.datasource.local.AppDatabase
import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.functional.catching
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.presentation.ConfigView
import javax.inject.Inject

/**
 * @author diegovidal on 19/01/19.
 */
class ConfigLocalDataSource @Inject constructor(
        private val appDatabase: AppDatabase
): ConfigRepository {

    override fun fetchConfig(): EitherResult<ConfigView?> {
        return catching { appDatabase.configDao().fetchConfig()?.mapperToConfigView()  }
    }

    override fun addConfig(configDto: ConfigDto?): EitherResult<Long> {
        return catching { appDatabase.configDao().addConfig(configDto) }
    }

    override fun clearConfig(): EitherResult<Unit> {
        return catching { appDatabase.configDao().clearConfig() }
    }
}