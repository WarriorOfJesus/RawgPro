package gw.gobpo2005.rawg.main_page.ui.model

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

object ConverterUi {
    fun fromNetwork(data: GamesData) =
        ResultDataUi(
            id = data.id ?: 0,
            name = data.name ?: "",
            image = data.backgroundImage ?: "",
            playtime = data.playtime,
            updated = data.updated,
            released = data.released,
            rating = data.rating
        )

    private fun fromNetwork(list: List<GamesData>): List<ResultDataUi> {
        return list.map { data ->
            ResultDataUi(
                id = data.id,
                name = data.name,
                image = data.backgroundImage,
                rating = data.rating,
                playtime = data.playtime,
                updated = data.updated,
                released = data.released
            )
        }
    }

    //    fun fromNetworkGenresChild(data: ResultsGenresData) = GamesDataUi(
//        id = data.id,
//        nameGame = data.name,
//        imageGame = data.imageBackground
//    )
//
    fun fromNetworkGenresParent(data: GenresData) = ParentGenresDataUi(
        id = data.id,
        nameGenres = data.name,
        listOfGames = fromNetwork(data.games),
        image = data.imageBackground
    )

    private fun fromNetworkResult(list: List<GamesData>): List<ResultDataUi> {
        return list.map { data ->
            ResultDataUi(
                id = data.id,
                name = data.name,
                image = data.backgroundImage,
                rating = data.rating,
                playtime = data.playtime,
                updated = data.updated,
                released = data.released
            )
        }
    }


}