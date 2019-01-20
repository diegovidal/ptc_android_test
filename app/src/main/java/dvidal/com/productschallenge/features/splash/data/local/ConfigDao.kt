package dvidal.com.productschallenge.features.splash.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author diegovidal on 19/01/19.
 */

@Dao
interface ConfigDao {

    @Query("SELECT * FROM configdto")
    fun fetchConfig(): ConfigDto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addConfig(configDto: ConfigDto): Long

    @Query("DELETE FROM configdto")
    fun clearConfig()
}