package gw.gobpo2005.rawg.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ItemScreenshotBinding
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot

class ScreenshotViewHolder(
    val binding: ItemScreenshotBinding,
    val clickOnScreenshot: (ShortScreenshot) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    constructor(
        parent: ViewGroup,
        clickOnScreenshot: (ShortScreenshot) -> Unit
    ) : this(
        ItemScreenshotBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickOnScreenshot
    )

    fun onBind(screenshot: ShortScreenshot) {
        itemView.setOnClickListener {
            clickOnScreenshot(screenshot)
        }

        with(binding) {
            Glide.with(itemView.context)
                .load(screenshot.image)
                .placeholder(R.drawable.abstract_game)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(screenshotImage)
        }

    }

}
