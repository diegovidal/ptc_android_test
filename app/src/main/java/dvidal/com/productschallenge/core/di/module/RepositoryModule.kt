package dvidal.com.productschallenge.core.di.module

import dagger.Module
import dagger.Provides
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.features.products.ProductsRepository
import dvidal.com.productschallenge.features.products.ProductsRepositoryImpl
import dvidal.com.productschallenge.features.products.data.cache.ProductsCacheDataSource
import dvidal.com.productschallenge.features.products.data.local.ProductsLocalDataSource
import dvidal.com.productschallenge.features.products.data.remote.ProductsRemoteDataSource
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.ConfigRepositoryImpl
import dvidal.com.productschallenge.features.splash.data.local.ConfigLocalDataSource
import dvidal.com.productschallenge.features.splash.data.remote.ConfigRemoteDataSource
import javax.inject.Singleton

/**
 * @author diegovidal on 21/12/18.
 */

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCustomersRepository(localDataSource: ConfigLocalDataSource,
                                   remoteDataSource: ConfigRemoteDataSource,
                                   generalPreferencesManager: GeneralPreferencesManager): ConfigRepository {

        return ConfigRepositoryImpl(localDataSource, remoteDataSource, generalPreferencesManager)
    }

    @Singleton
    @Provides
    fun provideProductsRepository(cacheDataSource: ProductsCacheDataSource,
                                  localDataSource: ProductsLocalDataSource,
                                  remoteDataSource: ProductsRemoteDataSource,
                                  generalPreferencesManager: GeneralPreferencesManager): ProductsRepository {

        return ProductsRepositoryImpl(cacheDataSource, localDataSource, remoteDataSource, generalPreferencesManager)
    }
}