package android.ptc.com.ptcflixing.utils

import android.ptc.com.ptcflixing.features.splash.data.local.ConfigDto
import gizmin.com.br.bitfazpdv.core.util.DataFactory

/**
 * @author diegovidal on 19/01/19.
 */
object ConfigDataFactory {

    fun makeConfigDto(): ConfigDto {

        return ConfigDto(
                id = DataFactory.randomString(),
                expire = DataFactory.randomString(),
                token = DataFactory.randomString(),
                currencyIso = DataFactory.randomString(),
                currencySymbol = DataFactory.randomString(),
                language = DataFactory.randomString()
        )
    }
}