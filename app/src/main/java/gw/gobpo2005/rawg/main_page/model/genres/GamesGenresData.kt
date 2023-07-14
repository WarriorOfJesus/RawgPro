package gw.gobpo2005.rawg.main_page.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesGenresData(
    val id: Int,
    val slug: String,
    val name: String,
    val added: Int
) : Parcelable
