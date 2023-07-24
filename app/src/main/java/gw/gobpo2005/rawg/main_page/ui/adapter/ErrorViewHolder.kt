package gw.gobpo2005.rawg.main_page.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import gw.gobpo2005.rawg.common.data.Failure
import gw.gobpo2005.rawg.databinding.ErrorStateBinding
import gw.gobpo2005.rawg.databinding.ParentItemGameBinding

class ErrorViewHolder(
    val binding: ErrorStateBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(failure: Failure?){
        binding.messageTextView.text = failure?.message
    }
}