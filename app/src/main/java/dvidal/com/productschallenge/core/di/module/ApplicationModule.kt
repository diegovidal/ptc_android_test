package dvidal.com.productschallenge.core.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import javax.inject.Singleton

/**
 * @author diegovidal on 14/12/18.
 */

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: DaggerApplication): Context {

        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {

        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Singleton
    @Provides
    fun provideSharedPreferencesManager(sharedPreferences: SharedPreferences): GeneralPreferencesManager{

        return GeneralPreferencesManager(sharedPreferences)
    }

}