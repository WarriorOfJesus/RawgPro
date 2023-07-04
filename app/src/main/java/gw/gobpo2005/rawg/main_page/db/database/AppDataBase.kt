package gw.gobpo2005.rawg.main_page.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity


@Database(version = 1, entities = [GamesEntity::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun getGamesDao(): GamesDao
}