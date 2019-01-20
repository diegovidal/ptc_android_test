package dvidal.com.productschallenge.features.splash

/**
 * @author diegovidal on 20/01/19.
 */

data class ConfigView(
        val id: String = "",
        val expire: String = "",
        val token: String = "",
        val currencyIso: String = "",
        val currencySymbol: String = "",
        val language: String = ""
)