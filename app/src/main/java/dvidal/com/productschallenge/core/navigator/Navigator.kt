package dvidal.com.productschallenge.core.navigator

import android.content.Context
import android.content.Intent
import dvidal.com.productschallenge.core.datasource.sharedpreferences.GeneralPreferencesManager
import dvidal.com.productschallenge.features.products.presentation.details.ProductDetailsActivity
import dvidal.com.productschallenge.features.products.presentation.list.ProductsActivity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author diegovidal on 20/01/19.
 */

@Singleton
class Navigator @Inject constructor(
        private val generalPreferencesManager: GeneralPreferencesManager
) {

    fun showMain(context: Context) {

        if (generalPreferencesManager.getCurrencySymbol().isNotEmpty()){
            showProducts(context)
        }
    }

    private fun showProducts(context: Context) {

        ProductsActivity.callingIntent(context).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(it)
        }
    }

    fun showProductDetails(context: Context, productId : Long) {

        ProductDetailsActivity.callingIntent(context, productId).also {
            context.startActivity(it)
        }
    }
}