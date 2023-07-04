package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.model.GamesData

interface GameRepository {
    suspend fun getGamesData(key : String) : GamesData
}