package gw.gobpo2005.rawg.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import coil.load
import coil.transform.CircleCropTransformation
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentInfoGameBinding
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import gw.gobpo2005.rawg.utils.viewbinding.viewBinding
import timber.log.Timber

class InfoGameFragment : BaseFragment(R.layout.fragment_info_game) {

    companion object {
        fun newInstance(data: ResultDataUi) = InfoGameFragment().apply {
            arguments = bundleOf(Constants.LIST_OF_GAMES to data)
        }
    }


    private val data: ResultDataUi? by lazy {
        arguments?.getParcelable(Constants.LIST_OF_GAMES)
    }

    private val binding: FragmentInfoGameBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            nameGame.text = data?.name
            rating.rating = data?.rating ?: 0.0f
            releaseData.text = data?.released
            updated.text = data?.updated
            imageOfGame.load(data?.image) {
                crossfade(true)
                Timber.d("___load $this.")
                placeholder(R.drawable.ic_image_of_games)
                transformations(CircleCropTransformation())
            }
        }
    }
}