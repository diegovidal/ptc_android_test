package android.ptc.com.ptcflixing.features.products.data.local.currentpage

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class CurrentPage(
        @PrimaryKey val id: Long = 0,
        val currentPage: Int = 0
)