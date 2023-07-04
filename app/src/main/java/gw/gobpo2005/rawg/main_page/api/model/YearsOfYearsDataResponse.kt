package gw.gobpo2005.rawg.main_page.api.model

import com.google.gson.annotations.SerializedName

data class YearsOfYearsDataResponse(
    @SerializedName("year")
    val year: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("nofollow")
    val noFollow: Boolean?
)