package dvidal.com.productschallenge

import android.app.Application
import dvidal.com.productschallenge.core.di.component.AppComponent
import dvidal.com.productschallenge.core.di.component.DaggerAppComponent
import dvidal.com.productschallenge.core.di.module.ApplicationModule
import timber.log.Timber

/**
 * @author diegovidal on 18/01/19.
 */
class AndroidApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}