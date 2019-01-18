package gizmin.com.br.bitfazpdv.core.util

import android.ptc.com.ptcflixing.features.products.data.local.currentpage.CurrentPage

/**
 * @author diegovidal on 19/12/18.
 */
object GenreDataFactory {

    fun makeGenreDto(): CurrentPage {

        return CurrentPage(
                DataFactory.randomLong(), DataFactory.randomString()
        )
    }
}