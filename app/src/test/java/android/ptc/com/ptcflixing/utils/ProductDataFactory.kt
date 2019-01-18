package android.ptc.com.ptcflixing.utils

import android.ptc.com.ptcflixing.features.products.data.local.ProductDto
import gizmin.com.br.bitfazpdv.core.util.DataFactory
import java.util.*

/**
 * @author diegovidal on 18/01/19.
 */

object ProductDataFactory {

    fun makeProductDto(): ProductDto {

        return ProductDto(
                sku = DataFactory.randomLong(),
                name = DataFactory.randomString(),
                brand = DataFactory.randomString(),
                maxSavingPercentage = DataFactory.randomInt(),
                price = DataFactory.randomDouble(),
                specialPrice = DataFactory.randomDouble(),
                image = DataFactory.randomString(),
                rating = DataFactory.randomInt()
        )
    }
}