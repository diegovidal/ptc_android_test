package dvidal.com.productschallenge.features.products.presentation.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import dvidal.com.productschallenge.core.platform.BaseActivity
import android.view.MenuItem
import dvidal.com.productschallenge.R
import android.widget.SearchView


class ProductsActivity : BaseActivity(), SearchView.OnQueryTextListener {

    override fun layoutRes() = R.layout.activity_layout

    private var searchItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(savedInstanceState, ProductsFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu?.clear()
        menuInflater.inflate(R.menu.search, menu)
        searchItem = menu?.getItem(0)
        configureSearch()

        return super.onCreateOptionsMenu(menu)
    }

    private fun configureSearch() {

        val searchView = searchItem?.actionView as? SearchView
        searchView?.setOnQueryTextListener(this)

        searchItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {

            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                return true
            }
        })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        (supportFragmentManager.fragments[0] as? ProductsFragment)?.searchFor(newText ?: "")
        return true
    }

    companion object {

        fun callingIntent(context: Context) = Intent(context, ProductsActivity::class.java)
    }
}
