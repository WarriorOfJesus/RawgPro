package gw.gobpo2005.rawg.main_page.ui.model

data class GamesFullDataUi(
    val count: Int,
    val next: String?,
    val previous: String?,
    val result: List<GamesDataUi>,
    val seoTitle: String,
    val seoDescription: String,
    val seoKeywords: String,
    val seoH1: String,
    val noIndex: Boolean,
    val noFollow: Boolean,
    val description: String,
    val noFollowCollection: List<String>,
)