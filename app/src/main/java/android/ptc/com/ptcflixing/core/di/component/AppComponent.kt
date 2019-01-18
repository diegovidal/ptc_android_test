package android.ptc.com.ptcflixing.core.di.component

import android.ptc.com.ptcflixing.core.di.DaggerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author diegovidal on 18/01/19.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class
])
internal interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}