package dvidal.com.productschallenge.core.di.component

import dvidal.com.productschallenge.core.di.DaggerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dvidal.com.productschallenge.core.di.module.*
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelModule
import javax.inject.Singleton

/**
 * @author diegovidal on 18/01/19.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    DatabaseModule::class,
    RemoteModule::class,
    ViewModelModule::class,
    ScreenModule::class,
    RepositoryModule::class
])
internal interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}