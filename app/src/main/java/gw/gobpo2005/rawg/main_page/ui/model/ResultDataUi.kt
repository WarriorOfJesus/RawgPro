package gw.gobpo2005.rawg.main_page.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultDataUi(
    val name : String,
    val image : String
) : Parcelable