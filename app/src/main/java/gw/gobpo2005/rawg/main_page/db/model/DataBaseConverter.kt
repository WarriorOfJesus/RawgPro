package gw.gobpo2005.rawg.main_page.db.model

import gw.gobpo2005.rawg.main_page.model.ResultData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi

object DataBaseConverter {

    fun fromDataBase(gamesEntity: List<GamesEntity>) =
        gamesEntity.map {data ->
            ResultDataUi(
                name = data.name,
                image = data.image
            )
        }

    fun toDataBase(resultData: List<ResultData>) =
        resultData.map{data ->
            GamesEntity(
                id = data.id ?: 0,
                name = data.name ?: "",
                image = data.backgroundImage ?: ""
            )
        }
}