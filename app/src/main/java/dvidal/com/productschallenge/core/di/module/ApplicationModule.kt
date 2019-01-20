package dvidal.com.productschallenge.core.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import javax.inject.Singleton

/**
 * @author diegovidal on 14/12/18.
 */

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {

        return context
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