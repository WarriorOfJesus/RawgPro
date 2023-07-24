package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.databinding.ItemScreenshotBinding
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot
import timber.log.Timber

class ScreenshotAdapter(
) : RecyclerView.Adapter<ScreenshotViewHolder>() {
    private val screenshotList = mutableListOf<ShortScreenshot>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemScreenshotBinding.inflate(inflater, parent, false)
        return ScreenshotViewHolder(binding)
    }

    override fun getItemCount() = screenshotList.size

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        val screenshot = screenshotList[position]
        Timber.d("___OnBindViewHolder : $screenshot")
        holder.onBind(screenshot)
    }

    override fun onViewRecycled(holder: ScreenshotViewHolder) {
        super.onViewRecycled(holder)
    }

    fun setData(games: List<ShortScreenshot>) {
        Timber.d("___SetData games : $games")
        val diffCallBack = getDiffCallback(screenshotList, games)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        Timber.d("___SetData screenshotList: $screenshotList")
        Timber.d("___SetData games: $games")
        screenshotList.clear()
        screenshotList.addAll(games)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldList: List<ShortScreenshot>,
        newList: List<ShortScreenshot>,
    ) = object : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldResultData = oldList[oldItemPosition]
            val newResultData = newList[newItemPosition]
            return oldResultData.hashCode() == newResultData.hashCode()
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldResultData = oldList[oldItemPosition]
            val newResultData = newList[newItemPosition]
            return oldResultData == newResultData
        }
    }

}