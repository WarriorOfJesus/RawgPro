package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddedByStatus(
    val yet: Int,
    val owned: Int,
    val beaten: Int,
    val toPlay: Int,
    val dropped: Int,
    val playing: Int,
): Parcelable