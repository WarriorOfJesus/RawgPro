package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity

class GamesAdapterPaging :
    PagingDataAdapter<GamesEntity, GamesAdapterPaging.Holder>(GamesDiffCallBack()) {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val game = getItem(position) ?: return
        with(holder.binding) {
            nameOfGame.text = game.name
            loadGamesPhoto(imageOfGame, url = game.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGamesBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    private fun loadGamesPhoto(imageView: ImageView, url: String) {
        val context = imageView.context
        if (url.isNotBlank()) {
            Glide.with(context)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_image_of_games)
                .error(R.drawable.ic_image_of_games)
                .into(imageView)
        } else {
            Glide.with(context)
                .load(R.drawable.ic_image_of_games)
                .into(imageView)
        }
    }

    class Holder(
        val binding: ItemGamesBinding
    ) : RecyclerView.ViewHolder(binding.root)

}


class GamesDiffCallBack : DiffUtil.ItemCallback<GamesEntity>() {
    override fun areItemsTheSame(oldItem: GamesEntity, newItem: GamesEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GamesEntity, newItem: GamesEntity): Boolean {
        return oldItem == newItem
    }

}