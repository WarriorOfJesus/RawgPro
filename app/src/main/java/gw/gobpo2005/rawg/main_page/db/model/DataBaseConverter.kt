package gw.gobpo2005.rawg.main_page.db.model

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi

object DataBaseConverter {


    fun toDataBase(resultData: List<GamesData>) =
        resultData.map{data ->
            GamesEntity(
                id = data.id ?: 0,
                name = data.name ?: "",
                image = data.backgroundImage ?: "",
                rating = data.rating,
                released = data.released,
                slug = data.slug,
                playtime = data.playtime,
                updated = data.updated
            )
        }
}