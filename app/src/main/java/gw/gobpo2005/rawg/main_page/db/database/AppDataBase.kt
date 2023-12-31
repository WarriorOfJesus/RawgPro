package gw.gobpo2005.rawg.main_page.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.dao.GenresDao
import gw.gobpo2005.rawg.main_page.db.model.DataBaseTypeConverters
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity


@Database(version = 2, entities = [GamesEntity::class, GenresEntity::class])
@TypeConverters(DataBaseTypeConverters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getGamesDao(): GamesDao
    abstract fun getGenresDao(): GenresDao

}
