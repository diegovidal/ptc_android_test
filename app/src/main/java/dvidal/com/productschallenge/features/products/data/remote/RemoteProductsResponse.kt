package dvidal.com.productschallenge.features.products.data.remote

import com.squareup.moshi.Json
import dvidal.com.productschallenge.features.products.presentation.ProductView

/**
 * @author diegovidal on 20/01/19.
 */

data class RemoteProductResponse(
        val success: Boolean = false,
        @Json(name = "metadata") val data: RemoteProductsFormattedResponse
) {

    companion object {

        fun empty(): RemoteProductResponse {

            return RemoteProductResponse(data = RemoteProductsFormattedResponse())
        }
    }
}

data class RemoteProductsFormattedResponse(
        val sort: String = "",
        @Json(name = "total_products") val totalProducts: Int = 0,
        val title: String = "",
        val results: List<RemoteProduct> = emptyList()
)

data class RemoteProduct (
        val sku: Long = 0,
        val name: String = "",
        val brand: String = "",
        @Json(name = "max_saving_percentage") val maxSavingPercentage: Int = 0,
        val price: Double = 0.0,
        @Json(name = "special_price") val specialPrice: Double = 0.0,
        val image: String = "",
        @Json(name = "rating_average") val rating: Int? = 0
) {

    fun mapperToProductView(): ProductView {

        return ProductView(
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