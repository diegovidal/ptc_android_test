package dvidal.com.productschallenge.core.di.component

import dvidal.com.productschallenge.core.di.DaggerApplication
import dvidal.com.productschallenge.core.di.module.DatabaseModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dvidal.com.productschallenge.core.di.module.RemoteModule
import javax.inject.Singleton

/**
 * @author diegovidal on 18/01/19.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    DatabaseModule::class,
    RemoteModule::class
])
internal interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}