package dvidal.com.productschallenge.features.products.data.remote

import com.squareup.moshi.Json
import dvidal.com.productschallenge.features.products.presentation.ProductDetailsView

/**
 * @author diegovidal on 20/01/19.
 */
class RemoteProductDetailsResponse(
        val success: Boolean = false,
        @Json(name = "metadata") val data: ProductDetailsMetadata
) {

    fun mapperToProductDetailsView(): ProductDetailsView {

        return ProductDetailsView(
                sku = data.sku.toLong(),
                name = data.name,
                brand = data.brand,
                description = data.summary?.description ?: "",
                maxSavingPercentage = data.maxSavingPercentage,
                price = data.price.toDoubleOrNull(),
                specialPrice = data.price.toDoubleOrNull(),
                rating = data.rating?.average ?: 0,
                images = data.imageList
        )
    }

    companion object {

        fun empty(): RemoteProductDetailsResponse {

            return RemoteProductDetailsResponse(
                    data = ProductDetailsMetadata()
            )
        }
    }
}

class Rating {
    var average: Int = 0
    @Json(name = "ratings_total") var ratingsTotal: Int = 0
}

class Summary {
    @Json(name = "short_description") var shortDescription: String = ""
    var description: String = ""
}

class SellerEntity {
    var id: Int = 0
    var name: String = ""
    @Json(name = "delivery_time") var deliveryTime: String = ""
}

class ProductDetailsMetadata {

    var sku: String = ""
    var name: String = ""
    @Json(name = "max_saving_percentage") var maxSavingPercentage: Int = 0
    var price: String = ""
    @Json(name = "special_price") var specialPrice: String = ""
    var brand: String = ""
    var rating: Rating? = null
    @Json(name = "image_list") var imageList: List<String> = emptyList()
    var summary: Summary? = null
    @Json(name = "seller_entity") var sellerEntity: SellerEntity? = null
}