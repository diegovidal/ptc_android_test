package dvidal.com.productschallenge.core.di.component

import dagger.Component
import dvidal.com.productschallenge.core.di.module.ApplicationModule
import dvidal.com.productschallenge.core.di.module.DatabaseModule
import dvidal.com.productschallenge.core.di.module.RemoteModule
import dvidal.com.productschallenge.core.di.module.RepositoryModule
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelModule
import javax.inject.Singleton

/**
 * @author diegovidal on 18/01/19.
 */
@Singleton
@Component(modules = [
    ApplicationModule::class,
    DatabaseModule::class,
    RemoteModule::class,
    RepositoryModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun activityComponent(): ActivityComponent.Builder
}