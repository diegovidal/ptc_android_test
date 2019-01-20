package dvidal.com.productschallenge.features.splash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dvidal.com.productschallenge.AndroidApplication
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import dvidal.com.productschallenge.core.extension.failure
import dvidal.com.productschallenge.core.extension.observeEvent
import dvidal.com.productschallenge.core.navigator.Navigator
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    @Inject lateinit var navigator: Navigator

    private val viewModel by lazy {
        viewModelFactory.get<SplashViewModel>(this)
    }

    private fun injectDagger() {
        (application as AndroidApplication).appComponent.activityComponent()
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        injectDagger()

        navigator.showMain(this)

        viewModel?.let {
            observeEvent(it.eventLoadFinished, ::renderLoadFinished)
            failure(it.failure, ::renderFailure)
        }.also { viewModel?.loadConfig() }
    }

    private fun renderLoadFinished(isFinished: Boolean) {

        if (isFinished)
            navigator.showMain(this)
    }

    private fun renderFailure(failure: Throwable?) {

        Timber.e("error is $failure")
    }
}
