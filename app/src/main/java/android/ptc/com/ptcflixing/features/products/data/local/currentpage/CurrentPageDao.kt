package android.ptc.com.ptcflixing.features.products.data.local.currentpage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * @author diegovidal on 18/01/19.
 */

@Dao
interface CurrentPageDao {

    @Query("SELECT * FROM currentpage")
    fun fetchCurrentPage(): CurrentPage?

    @Insert(onConflict = REPLACE)
    fun incrementCurrentPage(): CurrentPage?

    @Query("DELETE FROM currentpage")
    fun clearCurrentPage()
}