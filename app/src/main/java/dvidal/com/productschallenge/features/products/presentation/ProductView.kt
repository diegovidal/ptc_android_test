package dvidal.com.productschallenge.features.products.presentation

import dvidal.com.productschallenge.features.products.data.local.ProductDto

/**
 * @author diegovidal on 18/01/19.
 */
data class ProductView(
        val sku: Long = 0,
        val name: String = "",
        val brand: String = "",
        val maxSavingPercentage: Int = 0,
        val price: Double = 0.0,
        val specialPrice: Double = 0.0,
        val image: String = "",
        val rating: Int? = 0
) {

    fun mapperToMovieDto(): ProductDto {

        return ProductDto(
                sku = sku,
                name = name,
                brand = brand,
                maxSavingPercentage = maxSavingPercentage,
                price = price,
                specialPrice = specialPrice,
                image = image,
                rating = rating
        )
    }
}