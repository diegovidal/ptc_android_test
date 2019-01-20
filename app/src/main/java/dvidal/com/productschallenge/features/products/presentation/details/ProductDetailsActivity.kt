package dvidal.com.productschallenge.features.products.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.platform.BaseActivity

/**
 * @author diegovidal on 18/01/19.
 */

class ProductDetailsActivity : BaseActivity() {

    var productId: Long = 0

    override fun layoutRes() = R.layout.activity_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadBundleExtras(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addFragment(savedInstanceState, ProductDetailsFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun loadBundleExtras(savedInstanceState: Bundle?){

        if (intent.hasExtra(EXTRA_PRODUCT_ID)){
            productId = intent.getLongExtra(EXTRA_PRODUCT_ID, 0)
        }
    }

    companion object {

        const val EXTRA_PRODUCT_ID = "EXTRA_PRODUCT_ID"

        fun callingIntent(context: Context, productId: Long): Intent {

            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT_ID, productId)
            return intent
        }
    }
}
