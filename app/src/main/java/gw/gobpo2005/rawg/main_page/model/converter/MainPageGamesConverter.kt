package gw.gobpo2005.rawg.main_page.model.converter

import gw.gobpo2005.rawg.main_page.api.model.games.*
import gw.gobpo2005.rawg.main_page.model.games.*

object MainPageGamesConverter {

    fun fromNetwork(response: GamesFullDataResponse) =
        GamesFullData(
            count = response.count ?: 0,
            next = response.next ,
            previous = response.previous ,
            result = response.results?.let { fromNetwork(it) } ?: emptyList(),
            seoTitle = response.seoTitle ?: "",
            seoDescription = response.seoDescription ?: "",
            seoKeywords = response.seoKeywords ?: "",
            seoH1 = response.seoH1 ?: "",
            noFollow = response.noFollow ?: false,
            description = response.description ?: "",
            noIndex = response.noIndex ?: false,
            noFollowCollection = response.noFollowCollection ?: emptyList()
        )


    private fun fromNetwork(response: List<GamesDataResponse>): List<GamesData> {
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

    private fun fromNetworkRatings(response: List<RatingDataResponse>): List<RatingData> {
        return response.map { data ->
            RatingData(
                id = data.id,
                title = data.title,
                count = data.count,
                percent = data.percent
            )

        }
    }

    private fun fromNetworkAddedByStatus(response: AddedByStatusResponse) =
        AddedByStatus(
            yet = response.yet ?: 0,
            owned = response.owned ?: 0,
            beaten = response.beaten ?: 0,
            toPlay = response.toPlay ?: 0,
            dropped = response.dropped ?: 0,
            playing = response.playing ?: 0
        )


    private fun fromNetworkFilters(response: FiltersDataResponse) =
        FiltersData(
            years = fromNetworkYears(response.years)
        )

    private fun fromNetworkYears(response: List<YearsDataResponse>): List<YearsData> {
        return response.map { data ->
            YearsData(
                from = data.from,
                to = data.to,
                filter = data.filter,
                decade = data.decade,
                years = data.years?.let { fromNetworkYearsOfYears(it) }
            )
        }
    }

    private fun fromNetworkYearsOfYears(response: List<YearsOfYearsDataResponse>): List<YearsOfYearsData> {
        return response.map { data ->
            YearsOfYearsData(
                year = data.year,
                count = data.count,
                noFollow = data.noFollow
            )
        }
    }

}



