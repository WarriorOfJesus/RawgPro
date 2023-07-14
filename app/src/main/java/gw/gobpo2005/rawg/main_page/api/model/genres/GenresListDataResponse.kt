package gw.gobpo2005.rawg.main_page.api.model.genres

import com.google.gson.annotations.SerializedName

data class GenresListDataResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<ResultsGenresDataResponse>
)
