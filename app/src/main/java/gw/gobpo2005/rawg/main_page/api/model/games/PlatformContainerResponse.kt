package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class PlatformContainerResponse(
    @SerializedName("platform")
    val platform: PlatformResponse
)
