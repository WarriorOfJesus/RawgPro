package gw.gobpo2005.rawg.main_page.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "genres"
)
@Parcelize
data class GenresEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "gamesCount")
    val gamesCount: Int?,
    @ColumnInfo(name = "imageBackground")
    val imageBackground: String?,
//    @ColumnInfo(name = "games")
//    val games: List<GamesData>? = emptyList()
) : Parcelable {
    fun toGenresData() = GenresData(
        id = id,
        name = name ?: "",
        slug = slug ?: "",
        gamesCount = gamesCount ?: 0,
        imageBackground = imageBackground ?: "",
//        games = games ?: emptyList()
    )

}