package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesFullData(
    val count: Int,
    val next: String?,
    val previous: String?,
    val result: List<GamesData>,
    val seoTitle: String,
    val seoDescription: String,
    val seoKeywords: String,
    val seoH1: String,
    val noIndex: Boolean,
    val noFollow: Boolean,
    val description: String,
    val noFollowCollection: List<String>,
) : Parcelable
