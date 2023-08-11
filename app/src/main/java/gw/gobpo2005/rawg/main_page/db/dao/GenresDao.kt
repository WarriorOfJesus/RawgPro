package gw.gobpo2005.rawg.main_page.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity


@Dao
interface GenresDao {
    @Query("SELECT * FROM genres")
    fun getGenres(): List<GenresEntity>
    @Query("SELECT * FROM genres ")
    fun pagingSource(): PagingSource<Int, GenresEntity>


    @Insert(entity = GenresEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(genres: List<GenresEntity>)
}
