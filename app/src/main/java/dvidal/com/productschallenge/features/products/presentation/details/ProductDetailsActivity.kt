package dvidal.com.productschallenge.features.products.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.platform.BaseActivity

/**
 * @author diegovidal on 18/01/19.
 */

class ProductDetailsActivity : BaseActivity() {

    override fun layoutRes() = R.layout.activity_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(savedInstanceState, ProductDetailsFragment())
    }

    companion object {

        fun callingIntent(context: Context) = Intent(context, ProductDetailsActivity::class.java)
    }
}
