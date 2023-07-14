package gw.gobpo2005.rawg.main_page.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi


@Entity(
    tableName = "games"
)
data class GamesEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "released")
    val released: String,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "playtime")
    val playtime: Int,
    @ColumnInfo(name = "updated ")
    val updated: String,
) {
    fun toGamesData() = GamesData(
        id = id,
        name = name,
        backgroundImage = image,
        rating = rating,
        released = released,
        playtime = playtime,
        updated = updated,
        slug = slug
    )


}

