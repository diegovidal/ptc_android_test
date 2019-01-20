package dvidal.com.productschallenge.features.splash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dvidal.com.productschallenge.AndroidApplication
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        viewModelFactory.get<SplashViewModel>(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        injectDagger()
    }

    private fun injectDagger() {
        (application as AndroidApplication).appComponent.activityComponent()
                .build().inject(this)
    }
}
