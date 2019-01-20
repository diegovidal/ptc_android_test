package dvidal.com.productschallenge.core.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dvidal.com.productschallenge.BuildConfig
import dvidal.com.productschallenge.core.datasource.remote.NetworkInterceptor
import dvidal.com.productschallenge.core.datasource.remote.RemoteApi
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author diegovidal on 26/12/18.
 */

@Module
class RemoteModule {

    companion object {

        private const val API_ENDPOINT = BuildConfig.API_ENDPOINT
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptor(): NetworkInterceptor {

        return NetworkInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttp(networkInterceptor: NetworkInterceptor): Call.Factory {
        return OkHttpClient.Builder()
                .readTimeout(10L, TimeUnit.SECONDS)
                .addInterceptor(networkInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {

        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, callFactory: Call.Factory): Retrofit {

        return Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(API_ENDPOINT)
                .build()
    }

    @Provides
    @Singleton
    fun provideBetService(retrofit: Retrofit): RemoteApi {

        return retrofit.create(RemoteApi::class.java)
    }

}