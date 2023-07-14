package gw.gobpo2005.rawg.main_page.model.converter

import gw.gobpo2005.rawg.main_page.api.model.games.GamesDataResponse
import gw.gobpo2005.rawg.main_page.api.model.genres.GenresListDataResponse
import gw.gobpo2005.rawg.main_page.api.model.genres.ResultsGenresDataResponse
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresListData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

object MainPageGenresConverter {

    private fun fromNetworkGenresList(response: GenresListDataResponse) = GenresListData(
        count = response.count ?: 0,
        next = response.next ?: "",
        previous = response.previous ?: "",
        results = fromNetworkResultGenres(response.results)
    )

    fun fromNetworkResultGenres(response: List<ResultsGenresDataResponse>): List<GenresData> {
        return response.map { data ->
            GenresData(
                id = data.id ?: 0,
                name = data.name ?: "",
                slug = data.slug ?: "",
                gamesCount = data.gamesCount ?: 0,
                imageBackground = data.imageBackground ?: "",
            )
        }
    }

    fun fromNetworkGames(
        genreName: String,
        games: List<GamesDataResponse>,
        genres: List<GenresData>
    ): List<GenresData> {
        return genres.map { genre ->
            if (genre.slug != genreName) genre
            else genre.copy(games = convertGames(games))
        }
    }


    private fun convertGames(response: List<GamesDataResponse>): List<GamesData> {
        return response.map { data ->
            GamesData(
                id = data.id ?: 0,
                slug = data.slug ?: "",
                name = data.name ?: "",
                released = data.released ?: "",
                backgroundImage = data.backgroundImage ?: "",
                rating = data.rating ?: 0.0F,
                playtime = data.playtime ?: 0,
                updated = data.updated ?: ""
            )
        }
    }

}

