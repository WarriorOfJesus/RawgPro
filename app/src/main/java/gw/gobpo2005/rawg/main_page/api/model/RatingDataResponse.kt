package gw.gobpo2005.rawg.main_page.api.model

import com.google.gson.annotations.SerializedName

data class RatingDataResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("percent")
    val percent: Float?,
)