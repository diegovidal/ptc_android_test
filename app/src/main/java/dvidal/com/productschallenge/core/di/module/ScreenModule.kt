package dvidal.com.productschallenge.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dvidal.com.productschallenge.core.di.scope.ScreenScope
import dvidal.com.productschallenge.core.platform.BaseFragment
import dvidal.com.productschallenge.features.products.presentation.details.ProductDetailsFragment
import dvidal.com.productschallenge.features.products.presentation.list.ProductsFragment
import dvidal.com.productschallenge.features.splash.presentation.SplashActivity

/**
 * @author diegovidal on 14/12/18.
 */

@Module
internal abstract class ScreenModule {

    @ScreenScope
    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity

    @ScreenScope
    @ContributesAndroidInjector
    internal abstract fun contributeProductsFragment(): ProductsFragment

    @ScreenScope
    @ContributesAndroidInjector
    internal abstract fun contributeProductDetailsFragment(): ProductDetailsFragment
}