package gw.gobpo2005.rawg.main_page.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GenresListData(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<GenresData>
) : Parcelable
