package dvidal.com.productschallenge.utils

import dvidal.com.productschallenge.core.util.DataFactory
import dvidal.com.productschallenge.features.products.data.local.ProductDto
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView

/**
 * @author diegovidal on 18/01/19.
 */

object ProductDetailsDataFactory {

    fun makeProductDetails(): ProductDetailsView {

        return ProductDetailsView(
                sku = DataFactory.randomLong(),
                name = DataFactory.randomString(),
                brand = DataFactory.randomString(),
                description = DataFactory.randomString(),
                maxSavingPercentage = DataFactory.randomInt(),
                price = DataFactory.randomDouble(),
                specialPrice = DataFactory.randomDouble(),
                rating = DataFactory.randomInt(),
                images = listOf(DataFactory.randomString(), DataFactory.randomString())
        )
    }
}