package gw.gobpo2005.rawg.main_page.ui.controller

import android.view.View
import android.view.ViewGroup
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.PartDefaultLoadStateBinding
import ru.surfstudio.android.easyadapter.pagination.EasyPaginationAdapter
import ru.surfstudio.android.easyadapter.pagination.PaginationState

class GamesFooterPaginationController :
    EasyPaginationAdapter.BasePaginationFooterController<GamesFooterPaginationController.Holder>() {

    override fun createViewHolder(
        parent: ViewGroup,
        listener: EasyPaginationAdapter.OnShowMoreListener
    ): Holder {
        return Holder(parent, listener)
    }

    inner class Holder(
        parent: ViewGroup,
        listener: EasyPaginationAdapter.OnShowMoreListener
    ) : EasyPaginationAdapter.BasePaginationFooterHolder(
        parent,
        R.layout.part_default_load_state
    ) {

        private val binding: PartDefaultLoadStateBinding =
            PartDefaultLoadStateBinding.bind(itemView)

        init {
            with(binding) {
                btnTryAgain.setOnClickListener { listener.onShowMore() }
                progressBar.visibility = View.GONE
                tvmessage.visibility = View.GONE
            }
        }

        override fun bind(state: PaginationState) {

            with(binding) {
                when (state) {
                    PaginationState.READY -> {
                        progressBar.visibility = View.VISIBLE
                        tvmessage.visibility = View.GONE
                        btnTryAgain.visibility = View.GONE
                    }
                    PaginationState.COMPLETE -> {
                        progressBar.visibility = View.GONE
                        tvmessage.visibility = View.GONE
                        btnTryAgain.visibility = View.GONE
                    }
                    PaginationState.ERROR -> {
                        progressBar.visibility = View.GONE
                        tvmessage.visibility = View.VISIBLE
                        btnTryAgain.visibility = View.VISIBLE
                    }
                    else -> {
                        throw IllegalArgumentException("unsupported state : $state")
                    }
                }
            }
        }

    }


}
