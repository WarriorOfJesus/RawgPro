package gw.gobpo2005.rawg.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FiltersData(
    val years: List<YearsData>,
): Parcelable