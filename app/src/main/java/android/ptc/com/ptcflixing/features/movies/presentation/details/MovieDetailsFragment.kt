package android.ptc.com.ptcflixing.features.movies.presentation.details


import android.os.Bundle
import android.ptc.com.ptcflixing.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 * @author diegovidal on 18/01/19.
 */
class MovieDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }


}