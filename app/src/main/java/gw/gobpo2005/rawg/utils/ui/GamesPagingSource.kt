package gw.gobpo2005.rawg.utils.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import timber.log.Timber

typealias GamesPageLoader = suspend (Int) -> List<GamesData>

class GamesPagingSource(
    private val loader: GamesPageLoader,
    private val pageSize: Int
) : PagingSource<Int, GamesData>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesData> {
        val pageIndex = params.key ?: 1
        Timber.d("___$pageIndex")
        return try {
            val games = loader.invoke(pageIndex)
            Timber.d("___${games.size}")
            val loadResult = LoadResult.Page(
                data = games,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = if (games.isNotEmpty()) pageIndex + 1/*(params.loadSize / pageSize)*/ else null
            )
            Timber.d("___${loadResult.nextKey}")
            return loadResult
        } catch (e: Exception) {
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GamesData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}