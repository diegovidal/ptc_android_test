package android.ptc.com.ptcflixing.features.products.presentation

/**
 * @author diegovidal on 18/01/19.
 */
data class ProductDetailsView (
        val sku: Long = 0,
        val name: String = "",
        val brand: String = "",
        val description: String = "",
        val maxSavingPercentage: Int = 0,
        val price: Double = 0.0,
        val specialPrice: Double = 0.0,
        val image: String = "",
        val rating: Int? = 0,
        val images: List<String> = emptyList()
)