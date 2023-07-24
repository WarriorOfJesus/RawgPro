package gw.gobpo2005.rawg.main_page.ui.controller

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ParentItemGameBinding
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.MainUi
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.android.easyadapter.pagination.EasyPaginationAdapter
import ru.surfstudio.android.easyadapter.pagination.PaginationState
import timber.log.Timber

class GamesController(
    private val onClickItemGame: (GamesData) -> Unit,
    private val onLoadGames: (genre: String, page: Int, itemPosition: Int) -> Unit
) : BindableItemController<MainUi.GamesList, GamesController.Holder>() {


    override fun createViewHolder(parent: ViewGroup): Holder {
        return Holder(parent)
    }

    override fun getItemId(data: MainUi.GamesList): Any = data.genre


    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<MainUi.GamesList>(parent, R.layout.parent_item_game) {

        private val binding = ParentItemGameBinding.bind(itemView)

        private val footerController = GamesFooterPaginationController()

        private lateinit var data: MainUi.GamesList

        private val adapter = EasyPaginationAdapter(footerController) {
            val layoutManager = binding.gamesRecycler.layoutManager as? LinearLayoutManager
                ?: return@EasyPaginationAdapter
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            onLoadGames(data.genre, data.games.nextPage, firstVisibleItemPosition)
        }

        private val fullGamesController = FullGamesController(onClickItemGame)

        init {
            binding.gamesRecycler.adapter = adapter
        }

        override fun bind(data: MainUi.GamesList) {
            Timber.d("___GamesController -> bind()")
            setAdapterItem(data.games)
            Timber.d("___GamesController data : ${data}")
            binding.gamesRecycler.scrollToPosition(data.lastVisiblePosition)
            this.data = data
            if (data.page == 1) onLoadGames(data.genre, data.page, 0)
        }

        private fun setAdapterItem(games: List<GamesData>) {
            Timber.d("___GamesController gamesList : ${games}")
            val itemList = ItemList.create()
            for (game in games) {
                itemList.add(game, fullGamesController)
            }
            Timber.d("___GamesController itemList :  ${itemList}")
            adapter.setItems(itemList, PaginationState.READY)
        }
    }

}