package gw.gobpo2005.rawg.main_page.model.genres

import android.os.Parcelable
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresData(
    val id: Int,
    val name: String,
    val slug: String,
    val gamesCount: Int,
    val imageBackground: String,
    val games: List<GamesData> = emptyList()//GamesGenresData was before
) : Parcelable {

    fun toGenres() = GenresEntity(
        id = id,
        name = name,
        slug = slug,
        gamesCount = gamesCount,
        imageBackground = imageBackground,
//        games = games
    )
}
