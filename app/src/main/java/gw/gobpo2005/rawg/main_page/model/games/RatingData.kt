package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingData(
    val id: Int?,
    val title: String?,
    val count: Int?,
    val percent: Float?,
): Parcelable
