package gw.gobpo2005.rawg.main_page.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "genres"
)
@Parcelize
data class GenresEntity(
    val name: String,
    @PrimaryKey
    val slug: String,
//    @ColumnInfo(name = "games")
//    val games: List<GamesData>? = emptyList()
) : Parcelable {
    fun toGenresData() = GenresData(
        name = name ,
        slug = slug
    )

}