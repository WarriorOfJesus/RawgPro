package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class GamesFullDataResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<GamesDataResponse> = emptyList(),
    @SerializedName("seo_title")
    val seoTitle: String?,
    @SerializedName("seo_description")
    val seoDescription: String?,
    @SerializedName("seo_keywords")
    val seoKeywords: String?,
    @SerializedName("seo_h1")
    val seoH1: String?,
    @SerializedName("noindex")
    val noIndex: Boolean?,
    @SerializedName("nofollow")
    val noFollow: Boolean?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("filters")
    val filters: FiltersDataResponse?,
    @SerializedName("nofollow_collection")
    val noFollowCollection : List<String>?
)
