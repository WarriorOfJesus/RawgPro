package gw.gobpo2005.rawg.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity

@Dao
interface GamesDao {
    @Query(value = "SELECT * FROM games WHERE slug LIKE :genre LIMIT :limit OFFSET :offset")
    fun getAllGames(genre: String, limit: Int, offset: Int): List<GamesEntity>

    @Insert(entity = GamesEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun setGames(games: List<GamesEntity>)
}