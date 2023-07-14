package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.databinding.ParentItemGameBinding
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.ui.model.GamesUi
import gw.gobpo2005.rawg.main_page.ui.model.ParentGenresDataUi
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi

class GenresAdapter(
    private val clickOnGame: (ResultDataUi) -> Unit,
    private val onLoadGames: (genre: String) -> Unit
) : RecyclerView.Adapter<GenreViewHolder>() {
    private var data = mutableListOf<GamesUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ParentItemGameBinding.inflate(inflater, parent, false)
        return GenreViewHolder(binding, clickOnGame, onLoadGames)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val item = data[position]
        holder.onBind(item, position == 0)
    }

//    fun setData(items: List<ParentGenresDataUi>) {
//        val diffCallBack = getDiffCallback(listOfGenres, items)
//        val diffResult = DiffUtil.calculateDiff(diffCallBack)
//        listOfGenres.clear()
//        listOfGenres.
//        diffResult.dispatchUpdatesTo(this)
//    }

    fun setGenres(items: List<ParentGenresDataUi>) {
//        data.putAll(items.map { it.nameGenres to PagingData.empty<GamesEntity>() })
//        genresList.clear()
//        genresList.addAll(items.map { it.nameGenres })
        data.clear()
        data.addAll(items.map { GamesUi(genre = it.nameGenres, PagingData.empty()) })
        notifyDataSetChanged()
    }

    fun setGames(gamesUi: GamesUi) {
//        val removeItemIndex = data.indexOfFirst {
//            it.genre == gamesUi.genre
//        }

//        data.removeAt(removeItemIndex)
//        data.add(removeItemIndex, gamesUi)
//        notifyItemChanged(removeItemIndex)

        val newData = data.map {
            if(it.genre == gamesUi.genre) it.copy(games = gamesUi.games)
            else it
        }
//        val diffUtilCallBack = getDiffCallback(data, newData)
//        val diffResult = DiffUtil.calculateDiff(diffUtilCallBack)
//        data.clear()
//        data.addAll(newData)
//        diffResult.dispatchUpdatesTo(this)

        data = newData.toMutableList()
        notifyDataSetChanged()

    }


    private fun getDiffCallback(
        oldList: List<GamesUi>,
        newList: List<GamesUi>
    ) = object : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldGenres = oldList[oldItemPosition]
            val newGenres = newList[newItemPosition]
            return oldGenres.hashCode() == newGenres.hashCode()
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldGenres = oldList[oldItemPosition]
            val newGenres = newList[newItemPosition]
            return oldGenres == newGenres
        }
    }
}
