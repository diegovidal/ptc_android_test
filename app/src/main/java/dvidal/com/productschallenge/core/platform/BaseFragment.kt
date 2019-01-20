package dvidal.com.productschallenge.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment
import dvidal.com.productschallenge.core.di.module.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * @author diegovidal on 14/12/18.
 */
abstract class BaseFragment: DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onResume() {
        super.onResume()
    }

    @LayoutRes
    internal abstract fun layoutRes(): Int
}