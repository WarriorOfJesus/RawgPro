package gw.gobpo2005.rawg.main_page.model.converter

import gw.gobpo2005.rawg.main_page.api.model.games.GamesDataResponse
import gw.gobpo2005.rawg.main_page.api.model.games.PlatformContainerResponse
import gw.gobpo2005.rawg.main_page.api.model.games.PlatformResponse
import gw.gobpo2005.rawg.main_page.api.model.genres.GenresListDataResponse
import gw.gobpo2005.rawg.main_page.api.model.genres.ResultsGenresDataResponse
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.games.Platform
import gw.gobpo2005.rawg.main_page.model.games.PlatformContainer
import gw.gobpo2005.rawg.main_page.model.genres.GenresListData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

object MainPageGenresConverter {

    private fun fromNetworkGenresList(response: GenresListDataResponse) = GenresListData(
        count = response.count ?: 0,
        results = fromNetworkResultGenres(response.results)
    )

    fun fromNetworkResultGenres(response: List<ResultsGenresDataResponse>): List<GenresData> {
        return response.map { data ->
            GenresData(
                name = data.name ?: "",
                slug = data.slug ?: "",
            )
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
                updated = data.updated ?: "",
                platforms = fromNetworkListPlatforms(data.platforms)
            )
        }
    }

    private fun fromNetworkListPlatforms(response : List<PlatformContainerResponse>) : List<PlatformContainer>{
        return response.map {data ->
            PlatformContainer(
                platform = fromNetworkPlatforms(data.platform)
            )
        }
    }

     fun fromNetworkPlatforms(response: PlatformResponse) =
        Platform(
            id = response.id,
            slug =response.slug,
            name = response.name
        )

}

