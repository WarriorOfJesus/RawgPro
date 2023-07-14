package gw.gobpo2005.rawg.main_page.api.model.games

import com.google.gson.annotations.SerializedName

data class YearsDataResponse(
    @SerializedName("from")
    val from: Int?,
    @SerializedName("to")
    val to: Int?,
    @SerializedName("filters")
    val filter: String?,
    @SerializedName("decade")
    val decade: Int?,
    @SerializedName("years")
    val years:List<YearsOfYearsDataResponse>?,
)