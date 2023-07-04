package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import timber.log.Timber

class GamesAdapter(
//    private val clickOnGame :
) : RecyclerView.Adapter<GamesViewHolder>() {
    private val data = mutableListOf<ResultDataUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        return GamesViewHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
        Timber.i("___OnBindViewHolder")
    }

    fun setData(items: List<ResultDataUi>) {
        data.clear()
        Timber.i("__SetDAta")
        data.addAll(items)
        notifyDataSetChanged()
    }
}