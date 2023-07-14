package gw.gobpo2005.rawg.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface GenresDao {
    @Query("SELECT * FROM genres")
    fun getGenres(): Flow<List<GenresEntity>>



    @Insert(entity = GenresEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(genres: List<GenresEntity>)
}