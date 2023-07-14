package gw.gobpo2005.rawg.main_page.api.model.genres

import com.google.gson.annotations.SerializedName

data class GamesGenresDataResponse(
    @SerializedName("id")
    val id : Int?,
    @SerializedName("slug")
    val slug : String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("added")
    val added : Int?
)
