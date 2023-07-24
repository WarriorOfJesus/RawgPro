package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import kotlinx.parcelize.Parcelize


@Parcelize
data class GamesData(
    val id: Int,
    val slug: String,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val rating: Float,
    val playtime: Int,
    val updated: String,
    val platforms: List<PlatformContainer>,
    val screenshot: List<ShortScreenshot> = emptyList()
) : Parcelable {

    fun toGamesEntity() = GamesEntity(
        name = name,
        image = backgroundImage,
        rating = rating,
        released = released,
        playtime = playtime,
        updated = updated,
        slug = slug,
        platforms = platforms,
        screenshots = screenshot
    )
}

//    5val tba: Boolean?,

//   8val ratingTop: Int?,
//    val ratings: List<RatingData>?,
//    val ratingsCount: Int?,
//    val reviewsTextCount: Int?,
//    val added: Int?,
//    val addedByStatus: AddedByStatus?,
//    val metacritic: Int?,

//    last val suggestionsCount: Int?,