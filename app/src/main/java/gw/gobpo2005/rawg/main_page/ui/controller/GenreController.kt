package gw.gobpo2005.rawg.main_page.ui.controller

import android.view.ViewGroup
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemGenreBinding
import gw.gobpo2005.rawg.main_page.ui.model.MainUi
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class GenreController : BindableItemController<MainUi.Genre, GenreController.Holder>() {

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    override fun getItemId(data: MainUi.Genre): Any = data.name

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<MainUi.Genre>(parent, R.layout.item_genre) {

        private val binding: ItemGenreBinding = ItemGenreBinding.bind(itemView)

        override fun bind(data: MainUi.Genre) {
            binding.genreName.text = data.name
        }

    }
}
