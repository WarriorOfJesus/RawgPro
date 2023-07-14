package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi


class GamesAdapter(
    private val clickOnGame: (ResultDataUi) -> Unit
) : RecyclerView.Adapter<GameViewHolder>() {
    private val listOfGames = mutableListOf<ResultDataUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGamesBinding.inflate(inflater, parent, false)
        return GameViewHolder(binding, clickOnGame)
    }

    override fun getItemCount() = listOfGames.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val listItem = listOfGames[position]
        holder.onBind(listItem)
    }

    fun setData(items: List<ResultDataUi>) {
        val diffCallBack = getDiffCallback(listOfGames, items)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        listOfGames.clear()
        listOfGames.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }


    private fun getDiffCallback(
        oldList: List<ResultDataUi>,
        newList: List<ResultDataUi>,
    ) = object : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldResultData = oldList[oldItemPosition]
            val newResultData = newList[newItemPosition]
            return oldResultData.id == newResultData.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldResultData = oldList[oldItemPosition]
            val newResultData = newList[newItemPosition]
            return oldResultData == newResultData
        }
    }
}
