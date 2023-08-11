package gw.gobpo2005.rawg.main_page.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.games.PlatformContainer
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "games"
)
@Parcelize
data class GamesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val image: String,
    val rating: Float,
    val released: String,
    val slug: String,
    val playtime: Int,
    val updated: String,
    val platforms: List<PlatformContainer>,
    val screenshots: List<ShortScreenshot>
) : Parcelable {
    fun toGamesData() = GamesData(
        id = id,
        name = name,
        backgroundImage = image,
        rating = rating,
        released = released,
        playtime = playtime,
        updated = updated,
        slug = slug,
        platforms = platforms,
        screenshot = screenshots
    )


}
