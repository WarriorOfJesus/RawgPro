package gw.gobpo2005.rawg.main_page.model.converter

import gw.gobpo2005.rawg.main_page.api.model.*
import gw.gobpo2005.rawg.main_page.model.*

object Converter {

    fun fromNetwork(response: GamesDataResponse) =
        GamesData(
            count = response.count ?: 0,
            next = response.next ?: "",
            previous = response.previous ?: "",
            result = response.result?.let { fromNetwork(it) },
            seoTitle = response.seoTitle ?: "",
            seoDescription = response.seoDescription ?: "",
            seoKeywords = response.seoKeywords ?: "",
            seoH1 = response.seoH1 ?: "",
            noFollow = response.noFollow ?: false,
            description = response.description ?: "",
            noIndex = response.noIndex ?: false,
            filters = response.filters?.let { fromNetworkFilters(it) },
            noFollowCollection = response.noFollowCollection ?: emptyList()
        )


    private fun fromNetwork(response: List<ResultDataResponse>): List<ResultData> {
        return response.map { data ->
            ResultData(
                id = data.id,
                slug = data.slug,
                name = data.name,
                released = data.released,
                tba = data.tba,
                backgroundImage = data.backgroundImage,
                rating = data.rating,
                ratingTop = data.ratingTop,
                ratings = data.ratings?.let { fromNetworkRatings(it) },
                ratingsCount = data.ratingsCount,
                reviewsTextCount = data.reviewsTextCount,
                added = data.added,
                addedByStatus = data.addedByStatus?.let { fromNetworkAddedByStatus(it) },
                metacritic = data.metacritic,
                playtime = data.playtime,
                suggestionsCount = data.suggestionsCount,
                updated = data.updated

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
            yet = response.yet,
            owned = response.owned,
            beaten = response.beaten,
            toPlay = response.toPlay,
            dropped = response.dropped,
            playing = response.playing
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



