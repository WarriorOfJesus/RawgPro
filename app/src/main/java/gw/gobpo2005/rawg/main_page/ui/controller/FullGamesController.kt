package gw.gobpo2005.rawg.main_page.ui.controller

import android.view.ViewGroup
import coil.load
import coil.transform.CircleCropTransformation
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGamesBinding
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import timber.log.Timber

class FullGamesController(
    private val onGamesItemClicked: (GamesData) -> Unit
) : BindableItemController<GamesData, FullGamesController.Holder>() {

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<GamesData>(parent, R.layout.item_games) {

        private val binding: ItemGamesBinding = ItemGamesBinding.bind(itemView)
        override fun bind(data: GamesData) {
            with(binding) {
                Timber.d("___FulGamesController : $data")
                nameOfGame.text = data.name


                imageOfGame.load(data.backgroundImage) {
                    crossfade(true)
                    placeholder(R.drawable.ic_info_image_game)
                    transformations(CircleCropTransformation())
                }
                itemView.setOnClickListener { onGamesItemClicked.invoke(data) }
            }
        }

    }

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    override fun getItemId(data: GamesData): Any = data.id
}