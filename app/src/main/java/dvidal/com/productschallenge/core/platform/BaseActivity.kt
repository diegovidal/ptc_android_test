package dvidal.com.productschallenge.core.platform

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.core.extension.inTransaction

/**
 * @author diegovidal on 14/12/18.
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }

    @LayoutRes
    internal abstract fun layoutRes(): Int

    fun addFragment(savedInstanceState: Bundle?, fragment: BaseFragment?) =

        fragment?.let {
            savedInstanceState ?: supportFragmentManager.inTransaction {
                add(R.id.fragmentContainer, it)
            }
        }
}