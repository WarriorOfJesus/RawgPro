package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResultDataShort(
    val id: Int,
//    val slug: String?,
    val name: String,
//    val released: String?,
//    val tba: Boolean?,
    val backgroundImage: String,
//    val rating: Float?,
//    val ratingTop: Int?,
//    val ratings: List<RatingData>?,
//    val ratingsCount: Int?,
//    val reviewsTextCount: Int?,
//    val added: Int?,
//    val addedByStatus: AddedByStatus?,
//    val metacritic: Int?,
//    val playtime: Int?,
//    val suggestionsCount: Int?,
//    val updated: String?,
) : Parcelable
