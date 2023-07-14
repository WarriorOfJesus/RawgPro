package gw.gobpo2005.rawg.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FiltersData(
    val years: List<YearsData>,
): Parcelable