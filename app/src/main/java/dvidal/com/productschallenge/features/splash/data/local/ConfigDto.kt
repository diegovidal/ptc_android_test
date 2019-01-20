package dvidal.com.productschallenge.features.splash.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author diegovidal on 19/01/19.
 */

@Entity
data class ConfigDto(
        @PrimaryKey val id: String = "",
        val expire: String = "",
        val token: String = "",
        val currencyIso: String = "",
        val currencySymbol: String = "",
        val language: String = ""
)