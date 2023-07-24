package gw.gobpo2005.rawg.main_page.ui.model

import android.os.Parcelable
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesDataUi(
    val id : Int,
    val name : String,
    val image : String,
    val rating : Float,
    val released: String,
    val playtime: Int,
    val updated: String,
    val shortScreenshot: List<ShortScreenshot>,
) : Parcelable