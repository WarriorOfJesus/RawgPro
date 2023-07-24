package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.GamesDataUi
import timber.log.Timber

class GameViewHolder(
    private val binding: ItemGamesBinding,
    private val clickOnGame: (GamesDataUi) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        clickOnGame: (GamesDataUi) -> Unit
    ) : this(
        ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickOnGame
    )

    fun onBind(item: GamesData?) {
        if(item == null ) return
        with(binding) {
            Timber.i("___ViewHolder : ${item.backgroundImage}")
            nameOfGame.text = item.name

//            val request = ImageRequest.Builder(imageOfGame.context)
//                .data("https://w.forfun.com/fetch/d6/d620a394f14eddac2b92d7d9b9da72d2.jpeg")
//                .target(imageOfGame)
//                .build()
            imageOfGame.load(item.backgroundImage) {
                crossfade(true)
                Timber.d("___load $this.")
                placeholder(R.drawable.ic_image_of_games)
                transformations(CircleCropTransformation())

//                itemView.setOnClickListener {
//                    clickOnGame(item)
//                }
            }
        }
    }
}


