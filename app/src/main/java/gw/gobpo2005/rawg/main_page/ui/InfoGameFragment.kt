package gw.gobpo2005.rawg.main_page.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.bumptech.glide.Glide
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentInfoGameBinding
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.games.Platform
import gw.gobpo2005.rawg.main_page.model.games.PlatformContainer
import gw.gobpo2005.rawg.main_page.ui.adapter.ScreenshotAdapter
import gw.gobpo2005.rawg.utils.Utils.LIST_OF_GAMES
import gw.gobpo2005.rawg.utils.viewbinding.viewBinding
import timber.log.Timber

class InfoGameFragment : BaseFragment(R.layout.fragment_info_game) {

    private lateinit var gamesData: GamesData

    private val screenshotAdapter: ScreenshotAdapter by lazy {
        ScreenshotAdapter()
    }

    companion object {
        fun newInstance(game: GamesData) =
            InfoGameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(LIST_OF_GAMES, game)
                }
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gamesData = arguments?.getParcelable(LIST_OF_GAMES)!!
    }

    private val data: GamesData? by lazy {
        arguments?.getParcelable(LIST_OF_GAMES)
    }


    private val binding: FragmentInfoGameBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            nameGame.text = data?.name
            rating.rating = data?.rating ?: 0.0f
            rbNumber.text = data?.rating.toString()
            inputReleaseData.text = data?.released
            inputUpdatedData.text = data?.updated.toString().substring(0, 10)
            inputPlatforms.text = setPlatforms(data?.platforms)
            screenshotRecycler.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            screenshotRecycler.adapter = screenshotAdapter
            data?.screenshot?.let { screenshotAdapter.setData(it) }
            imageOfGame.load(data?.backgroundImage) {
                crossfade(true)
                Timber.d("___load $this.")
                placeholder(R.drawable.ic_image_of_games)
            }
        }
    }

    private fun setPlatforms(platforms: List<PlatformContainer>?): String {
        val nameOfPlatforms = buildString {
            platforms?.map {
                append(it.platform.name)
                append(", ")
            }
        }
        return nameOfPlatforms
    }

    override fun onDestroy() {
        super.onDestroy()
        view?.let { context?.let { it1 -> Glide.with(it1).clear(it) } }
    }
}