package dvidal.com.productschallenge.features.splash.presentation

import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.core.platform.BaseViewModel
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import dvidal.com.productschallenge.features.splash.domain.usecases.AddConfigUseCase
import dvidal.com.productschallenge.features.splash.domain.usecases.FetchConfigUseCase
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */
class SplashViewModel @Inject constructor(
        private val fetchConfigUseCase: FetchConfigUseCase,
        private val addConfigUseCase: AddConfigUseCase
): BaseViewModel() {

    fun loadConfig() = fetchConfigUseCase.invoke(UseCase.None(), Dispatchers.IO, job) {
        it.either(::handleFailure, ::handleLoadConfig)
    }

    private fun saveConfig(configDto: ConfigDto?) = addConfigUseCase.invoke(configDto, Dispatchers.IO, job) {
        it.either(::handleFailure, ::handleSaveConfig)
    }

    private fun handleLoadConfig(configView: ConfigView?) {
        saveConfig(configView?.mapperToConfigDto())
    }

    private fun handleSaveConfig(configId: Long) {
        Timber.d("Config saved.")
    }
}