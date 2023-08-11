package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class AddedByStatusResponse(
    @SerializedName("yet")
    val yet: Int?,
    @SerializedName("owned")
    val owned: Int?,
    @SerializedName("beaten")
    val beaten: Int?,
    @SerializedName("toplay")
    val toPlay: Int?,
    @SerializedName("dropped")
    val dropped: Int?,
    @SerializedName("playing")
    val playing: Int?,
)
