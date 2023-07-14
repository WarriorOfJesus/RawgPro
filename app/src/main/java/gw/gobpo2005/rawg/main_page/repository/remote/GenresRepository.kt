package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.model.genres.GenresData

interface GenresRepository {

    suspend fun getGenresGames() : List<GenresData>
}