package dvidal.com.productschallenge.utils

import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView
import dvidal.com.productschallenge.core.util.DataFactory

/**
 * @author diegovidal on 19/01/19.
 */
object ProductDetailsFactory {

    fun makeProductDetails(): ProductDetailsView {

        return ProductDetailsView(
                sku = DataFactory.randomLong(),
                name = DataFactory.randomString(),
                brand = DataFactory.randomString(),
                description = DataFactory.randomString(),
                maxSavingPercentage = DataFactory.randomInt(),
                price = DataFactory.randomDouble(),
                specialPrice = DataFactory.randomDouble(),
                image = DataFactory.randomString(),
                rating = DataFactory.randomInt(),
                images = listOf(DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString())
        )
    }
}