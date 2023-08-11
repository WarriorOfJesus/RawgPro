package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResultDataShort(
    val id: Int,
    val name: String,
    val backgroundImage: String,
) : Parcelable
