package gw.gobpo2005.rawg.main_page.api

import gw.gobpo2005.rawg.main_page.api.model.games.GamesFullDataResponse
import gw.gobpo2005.rawg.main_page.api.model.genres.GenresListDataResponse
import gw.gobpo2005.rawg.utils.Utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {

    @GET("api/games")
    suspend fun getListOfGame(
        @Query("page") page: Int,
        @Query("key") key: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("genres") genres: String
    ): GamesFullDataResponse

    @GET("api/genres")
    suspend fun getListOfGenres(
        @Query("key") key: String = API_KEY
    ): GenresListDataResponse

}
