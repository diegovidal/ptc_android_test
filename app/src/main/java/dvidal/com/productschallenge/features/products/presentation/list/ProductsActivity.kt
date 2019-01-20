package dvidal.com.productschallenge.features.products.presentation.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.platform.BaseActivity

class ProductsActivity : BaseActivity() {

    override fun layoutRes() = R.layout.activity_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(savedInstanceState, ProductsFragment())
    }

    companion object {

        fun callingIntent(context: Context) = Intent(context, ProductsActivity::class.java)
    }
}
