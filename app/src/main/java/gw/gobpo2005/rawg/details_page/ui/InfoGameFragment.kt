package gw.gobpo2005.rawg.details_page.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentInfoGameBinding
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.games.PlatformContainer
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot
import gw.gobpo2005.rawg.main_page.ui.adapter.ScreenshotAdapter
import gw.gobpo2005.rawg.utils.Utils.GAME_KEY
import timber.log.Timber

class InfoGameFragment : BaseFragment(R.layout.fragment_info_game) {

    companion object {
        fun newInstance(game: GamesData) =
            InfoGameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(GAME_KEY, game)
                }
            }
    }


    private val screenshotAdapter: ScreenshotAdapter by lazy {
        ScreenshotAdapter(
            clickOnScreenshot = {
                onScreenshotItemClicked(
                    it
                )
            }
        )
    }


    private val data: GamesData? by lazy {
        arguments?.getParcelable(GAME_KEY)
    }


    private lateinit var binding: FragmentInfoGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoGameBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun initViews() {
        with(binding) {
            nameGame.text = data?.name
            if (data?.rating != null) {
                rating.rating = data!!.rating
            }
            rbNumber.text = data?.rating.toString()
            inputReleaseData.text = data?.released
            inputUpdatedData.text = data?.updated.toString().substring(0, 10)
            inputPlatforms.text = setPlatforms(data?.platforms)
            txtNameGenre.text = checkString(data?.slug.toString())
            screenshotRecycler.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            screenshotRecycler.adapter = screenshotAdapter
            data?.screenshot?.let { screenshotAdapter.setData(it) }
            imageOfGame.load(data?.backgroundImage) {
                crossfade(true)
                Timber.d("___load $this.")
                placeholder(R.drawable.ic_downloading)
            }

            imbtBack.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

    override fun bind() {}

    private fun setPlatforms(platforms: List<PlatformContainer>?): String {
        return buildString {
            platforms?.map {
                append(it.platform.name)
                append(", ")
            }
        }
    }

    private fun checkString(string: String): CharSequence {
        return if (string.length == 22) string.substring(19, 22) else return string
    }

    override fun onDestroy() {
        super.onDestroy()
        view?.let { context?.let { it1 -> Glide.with(it1).clear(it) } }
    }


    private fun onScreenshotItemClicked(screenshot: ShortScreenshot) {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_alone_screenshot, null)
        val imageView = dialogView.findViewById<ImageView>(R.id.screenshotImage)

        Glide.with(requireContext())
            .load(screenshot.image)
            .placeholder(R.drawable.ic_downloading)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)

        AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .show()
    }
}
