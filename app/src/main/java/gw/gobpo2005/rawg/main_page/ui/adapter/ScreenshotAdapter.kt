package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot

class ScreenshotAdapter(
    private val clickOnScreenshot: (ShortScreenshot) -> Unit
) : RecyclerView.Adapter<ScreenshotViewHolder>() {
    private val screenshotList = mutableListOf<ShortScreenshot>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_screenshot, parent, false)
        return ScreenshotViewHolder(parent, clickOnScreenshot)
    }

    override fun getItemCount() = screenshotList.size

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        val screenshot = screenshotList[position]
        holder.onBind(screenshot)
    }

    override fun onViewRecycled(holder: ScreenshotViewHolder) {
        super.onViewRecycled(holder)
    }

    fun setData(games: List<ShortScreenshot>) {
        val diffCallBack = getDiffCallback(screenshotList, games)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
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
