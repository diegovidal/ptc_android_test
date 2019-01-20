package dvidal.com.productschallenge.core.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import dvidal.com.productschallenge.features.products.presentation.details.ProductDetailsViewModel
import dvidal.com.productschallenge.features.products.presentation.list.ProductsViewModel
import dvidal.com.productschallenge.features.splash.presentation.SplashViewModel
import javax.inject.Singleton

/**
 * @author diegovidal on 17/12/18.
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindsProductsViewModel(viewModel: ProductsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun bindsProductDetailsViewModel(viewModel: ProductDetailsViewModel): ViewModel
}