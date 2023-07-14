package gw.gobpo2005.rawg.main_page.ui.adapter

import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.databinding.ParentItemGameBinding
import gw.gobpo2005.rawg.main_page.ui.model.GamesUi
import gw.gobpo2005.rawg.main_page.ui.model.ParentGenresDataUi
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenreViewHolder(
    val binding: ParentItemGameBinding,
    val clickOnGame: (ResultDataUi) -> Unit,
    val onLoadGames: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private val pagingAdapter: GamesAdapterPaging = GamesAdapterPaging()

    val scope = CoroutineScope(Dispatchers.Main.immediate)


    init {
        with(binding) {
            childRecycler.adapter = pagingAdapter
            childRecycler.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

        }
    }

    fun onBind(item: GamesUi, isFirst: Boolean) {
        with(binding) {
            genreName.text = item.genre
            if (item.isLoadEnabled) {
                item.isLoadEnabled = false
                onLoadGames(item.genre)
            }
//            if(isFirst)  scope.launch {
//                pagingAdapter.submitData(item.games)
//            }
        }
    }
}
