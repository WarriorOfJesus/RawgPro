package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)
