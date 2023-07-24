package gw.gobpo2005.rawg.main_page.model.genres

import android.os.Parcelable
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresData(
    val name: String,
    val slug: String,
) : Parcelable {

    fun toGenres() = GenresEntity(
        name = name,
        slug = slug
    )
}
