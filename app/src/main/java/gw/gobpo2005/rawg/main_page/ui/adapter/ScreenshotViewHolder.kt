package gw.gobpo2005.rawg.main_page.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemScreenshotBinding
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot
import timber.log.Timber

class ScreenshotViewHolder(
    val binding: ItemScreenshotBinding
) : RecyclerView.ViewHolder(binding.root) {
//        private val imageScreenshotView: ImageView = itemView.findViewById(R.id.screenshotImage)


    fun onBind(screenshot: ShortScreenshot) {
        Timber.d("___ScreenShotOnBind : $screenshot")

        with(binding) {
            Glide.with(itemView.context)
                .load(screenshot.image)
                .placeholder(R.drawable.ic_info_image_game)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(screenshotImage)
        }

    }

}