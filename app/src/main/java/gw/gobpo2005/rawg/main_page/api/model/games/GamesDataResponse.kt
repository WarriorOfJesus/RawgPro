package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class GamesDataResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("tba")
    val tba: Boolean?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("rating")
    val rating: Float?,
    @SerializedName("rating_top")
    val ratingTop: Int?,
    @SerializedName("ratings")
    val ratings: List<RatingDataResponse>?,
    @SerializedName(" ratings_count")
    val ratingsCount: Int?,
    @SerializedName(" reviews_text_count")
    val reviewsTextCount: Int?,
    @SerializedName("added")
    val added: Int?,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatusResponse?,
    @SerializedName("metacritic")
    val metacritic: Int?,
    @SerializedName("playtime")
    val playtime: Int?,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("parent_platforms")
    val platforms: List<PlatformContainerResponse>,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotResponse>
)
