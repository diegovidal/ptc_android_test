package android.ptc.com.ptcflixing.features.products.data.local

import android.ptc.com.ptcflixing.features.products.presentation.ProductView
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author diegovidal on 18/01/19.
 */

@Entity
data class ProductDto(
        @PrimaryKey val sku: Long = 0,
        val name: String = "",
        val brand: String = "",
        val maxSavingPercentage: Int = 0,
        val price: Double = 0.0,
        val specialPrice: Double = 0.0,
        val image: String = "",
        val rating: Int? = 0
) {

    fun mapperToMovieView(): ProductView {

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