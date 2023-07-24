//package gw.gobpo2005.rawg.main_page.ui.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import gw.gobpo2005.rawg.databinding.ParentItemGameBinding
//import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
//import gw.gobpo2005.rawg.main_page.ui.model.GamesDataUi
//import gw.gobpo2005.rawg.main_page.ui.model.GenresUi
//import timber.log.Timber
//
//class GenresAdapter(
//    private val clickOnGame: (GamesDataUi) -> Unit,
//    private val onLoadGames: (genre: GenresUi) -> Unit
//) : RecyclerView.Adapter<GenreViewHolder>() {
//    private var data = mutableListOf<GenresUi>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
//        Timber.d("___OnCreateViewHolder")
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ParentItemGameBinding.inflate(inflater, parent, false)
//        return GenreViewHolder(binding, clickOnGame, onLoadGames)
//    }
//
//    override fun getItemCount() = data.size
//
//    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
//        val item = data[position]
//        Timber.d("___Genres Adapter items : $item")
//        holder.onBind(item)
//    }
//
//    fun setData(items: List<GenresUi>) {
//        val diffCallBack = getDiffCallback(data, items)
//        val diffResult = DiffUtil.calculateDiff(diffCallBack)
//        data.clear()
//        data.addAll(items)
////        notifyDataSetChanged()
//        diffResult.dispatchUpdatesTo(this)
//    }
//
//    private fun getDiffCallback(
//        oldList: List<GenresUi>,
//        newList: List<GenresUi>
//    ) = object : DiffUtil.Callback() {
//        override fun getOldListSize() = oldList.size
//
//        override fun getNewListSize() = newList.size
//
//        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            val oldGenres = oldList[oldItemPosition]
//            val newGenres = newList[newItemPosition]
//            return oldGenres.hashCode() == newGenres.hashCode()
//        }
//
//        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            val oldGenres = oldList[oldItemPosition]
//            val newGenres = newList[newItemPosition]
//            return oldGenres == newGenres
//        }
//    }
//}
