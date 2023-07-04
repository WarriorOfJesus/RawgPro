package gw.gobpo2005.rawg.main_page.api

import gw.gobpo2005.rawg.main_page.api.model.GamesDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {

    @GET("api/games")
    suspend fun getListOfGame(
        @Query("key") key : String
    ) : GamesDataResponse

}