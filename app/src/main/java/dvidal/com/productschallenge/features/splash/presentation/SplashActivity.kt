package dvidal.com.productschallenge.features.splash.presentation

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dvidal.com.productschallenge.R

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
