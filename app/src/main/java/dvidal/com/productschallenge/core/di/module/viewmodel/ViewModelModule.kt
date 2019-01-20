package dvidal.com.productschallenge.core.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dvidal.com.productschallenge.features.products.presentation.details.ProductDetailsViewModel
import dvidal.com.productschallenge.features.products.presentation.list.ProductsViewModel
import dvidal.com.productschallenge.features.splash.presentation.SplashViewModel

/**
 * @author diegovidal on 17/12/18.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindProductsViewModel(viewModel: ProductsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun bindProductDetailsViewModel(viewModel: ProductDetailsViewModel): ViewModel

}