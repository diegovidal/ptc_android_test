package dvidal.com.productschallenge

import dvidal.com.productschallenge.core.di.DaggerApplication
import timber.log.Timber

/**
 * @author diegovidal on 18/01/19.
 */
class AndroidApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}