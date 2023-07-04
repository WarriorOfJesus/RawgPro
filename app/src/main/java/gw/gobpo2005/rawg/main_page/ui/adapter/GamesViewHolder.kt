package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi

class GamesViewHolder(
    private val binding: ItemGamesBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup
    ) : this(
        ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: ResultDataUi) {
        with(binding) {
            nameOfGame.text = item.name
            imageOfGame.load(item.image) {
                crossfade(false)
                placeholder(R.drawable.ic_image_of_games)
                transformations(CircleCropTransformation())
            }
        }
    }
}
