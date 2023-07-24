package gw.gobpo2005.rawg.main_page.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.main_page.ui.model.GenresUi

const val VISIBLE_THRESHOLD = 10

class MainScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadNextPage: (GenresUi) -> Unit,
    private val gameGenre: GenresUi
): RecyclerView.OnScrollListener() {

    private var isLoading = true

    private var totalLoadedItems = 0
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItems = layoutManager.childCount
        val totalItems = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (totalItems == visibleItems) return

        if (totalItems > totalLoadedItems) {
            isLoading = false
            totalLoadedItems = totalItems
            return
        }

        val shouldLoadMore = totalItems - visibleItems <= firstVisibleItemPosition + VISIBLE_THRESHOLD
        if (!isLoading && shouldLoadMore) {
            gameGenre.page++
            loadNextPage(gameGenre)
            isLoading = true
        }
    }

    fun reset() {
        isLoading = false
        totalLoadedItems = 0
        gameGenre.page = 1
    }
}