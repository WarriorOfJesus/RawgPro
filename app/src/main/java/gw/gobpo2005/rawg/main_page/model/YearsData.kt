package gw.gobpo2005.rawg.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YearsData(
    val from: Int?,
    val to: Int?,
    val filter: String?,
    val decade: Int?,
    val years:List<YearsOfYearsData>?,
) : Parcelable