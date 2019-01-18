package android.ptc.com.ptcflixing.features.products.data.local.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author diegovidal on 18/01/19.
 */

@Dao
interface ProductsDao {

    @Query("SELECT * FROM productdto")
    fun fetchProducts(): List<ProductDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(productDto: ProductDto): Long

    @Query("DELETE FROM productdto")
    fun clearProducts()
}