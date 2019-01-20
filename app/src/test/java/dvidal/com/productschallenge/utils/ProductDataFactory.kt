package dvidal.com.productschallenge.utils

import dvidal.com.productschallenge.features.products.data.local.ProductDto
import dvidal.com.productschallenge.core.util.DataFactory

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