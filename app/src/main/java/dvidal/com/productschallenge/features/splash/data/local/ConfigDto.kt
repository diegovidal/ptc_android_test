package dvidal.com.productschallenge.features.splash.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import dvidal.com.productschallenge.features.splash.ConfigView

/**
 * @author diegovidal on 19/01/19.
 */

@Entity
data class ConfigDto(
        @PrimaryKey var id: String = "",
        val expire: String = "",
        val token: String = "",
        val currencyIso: String = "",
        val currencySymbol: String = "",
        val language: String = ""
) {

    fun mapperToConfigView(): ConfigView {

        return ConfigView(
                id = id,
                expire = expire,
                token = token,
                currencyIso = currencyIso,
                currencySymbol = currencySymbol,
                language = language
        )
    }
}