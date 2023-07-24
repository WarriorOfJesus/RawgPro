package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

class ShortScreenshotResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)
