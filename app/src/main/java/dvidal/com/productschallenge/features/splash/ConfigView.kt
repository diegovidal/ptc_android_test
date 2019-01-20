package dvidal.com.productschallenge.features.splash

import dvidal.com.productschallenge.features.splash.data.local.ConfigDto

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
) {

    fun mapperToConfigDto(): ConfigDto {

        return ConfigDto(
                id = id,
                expire = expire,
                token = token,
                currencyIso = currencyIso,
                currencySymbol = currencySymbol,
                language = language
        )
    }
}