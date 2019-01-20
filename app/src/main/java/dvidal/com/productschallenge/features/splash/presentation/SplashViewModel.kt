package dvidal.com.productschallenge.features.splash.presentation

import androidx.lifecycle.MutableLiveData
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.core.platform.BaseViewModel
import dvidal.com.productschallenge.core.platform.MutableLiveEvent
import dvidal.com.productschallenge.core.platform.postEvent
import dvidal.com.productschallenge.features.splash.domain.usecases.AddConfigUseCase
import dvidal.com.productschallenge.features.splash.domain.usecases.FetchConfigUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */
class SplashViewModel @Inject constructor(
        private val fetchConfigUseCase: FetchConfigUseCase,
        private val addConfigUseCase: AddConfigUseCase
): BaseViewModel() {

    val eventLoadFinished by lazy { MutableLiveEvent<Boolean>() }

    fun loadConfig() {

        eventLoadFinished.postEvent(false)
        fetchConfigUseCase.invoke(UseCase.None(), Dispatchers.IO, job) {
            it.either(::handleFailure, ::handleLoadConfig)
        }
    }

    private fun handleLoadConfig(configView: ConfigView?) {
        eventLoadFinished.postEvent(true)
    }
}