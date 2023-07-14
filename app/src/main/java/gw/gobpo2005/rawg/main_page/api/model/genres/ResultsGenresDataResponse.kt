package gw.gobpo2005.rawg.main_page.api.model.genres

import com.google.gson.annotations.SerializedName
import gw.gobpo2005.rawg.main_page.api.model.genres.GamesGenresDataResponse

data class ResultsGenresDataResponse(
    @SerializedName("id")
    val id : Int?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("slug")
    val slug : String?,
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("image_background")
    val imageBackground : String?,
    @SerializedName("games")
    val games : List<GamesGenresDataResponse>
)
