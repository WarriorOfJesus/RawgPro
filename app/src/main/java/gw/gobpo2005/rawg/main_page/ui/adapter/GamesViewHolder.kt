package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import timber.log.Timber

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
            Timber.i("___ViewHolder : ${item.image}")
            nameOfGame.text = item.name

//            val request = ImageRequest.Builder(imageOfGame.context)
//                .data("https://w.forfun.com/fetch/d6/d620a394f14eddac2b92d7d9b9da72d2.jpeg")
//                .target(imageOfGame)
//                .build()
            imageOfGame.load("https://w.forfun.com/fetch/d6/d620a394f14eddac2b92d7d9b9da72d2.jpeg"){
                crossfade(true)
                Timber.d("___load $this.")
                placeholder(R.drawable.ic_image_of_games)
                    this.size(80)
                this.target(imageOfGame)
                transformations(CircleCropTransformation())
            }
        }
    }
}
