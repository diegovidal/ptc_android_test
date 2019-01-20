package dvidal.com.productschallenge.core.di.component

import dagger.Subcomponent
import dvidal.com.productschallenge.features.products.presentation.details.ProductDetailsFragment
import dvidal.com.productschallenge.features.products.presentation.list.ProductsFragment
import dvidal.com.productschallenge.features.splash.presentation.SplashActivity

/**
 * @author diegovidal on 09/11/18.
 */

@Subcomponent()
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(productsFragment: ProductsFragment)
    fun inject(productDetailsFragment: ProductDetailsFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ActivityComponent
    }
}