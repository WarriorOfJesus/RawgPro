package gw.gobpo2005.rawg.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query(value = "SELECT * FROM games")
    fun getAllGames() : Flow<List<GamesEntity>>

    @Insert(entity = GamesEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(games : List<GamesEntity>)
}