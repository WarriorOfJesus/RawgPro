package gw.gobpo2005.rawg.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentListOfGamesBinding
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.controller.GamesController
import gw.gobpo2005.rawg.main_page.ui.controller.GenreController
import gw.gobpo2005.rawg.main_page.ui.model.MainUi
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import timber.log.Timber

class ListOfGamesFragment : BaseFragment(R.layout.fragment_list_of_games) {

    private val viewModel: RawgViewModel by viewModel()
    private lateinit var binding: FragmentListOfGamesBinding

    private val easyAdapter = EasyAdapter()

    private val gamesController = GamesController(
        onClickItemGame = { onGamesItemClicked(it) },
        onLoadGames = { genre, page, itemPosition ->
            viewModel.loadGames(
                genre,
                page,
                itemPosition
            )
        }
    )

    private val genreController = GenreController()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfGamesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setObserves()
    }

    private fun setObserves() {
        with(viewModel) {
            observe(mainUi) { mainUiList ->
                val itemList = ItemList.create()
                Timber.d("___MainUiList : $mainUiList")
                mainUiList.forEach { item ->
                    when (item) {
                        is MainUi.GamesList -> itemList.add(item, gamesController)
                        is MainUi.Genre -> itemList.add(item, genreController)
                    }
                }
                Timber.d("___itemList : $itemList ")
                easyAdapter.setItems(itemList)
            }

            observe(isLoading) { loading ->
                binding.progressBar.isVisible = loading
//                binding.recyclerOfGames.isVisible = !loading
            }
//            observe(loading) { isLoading ->
//                binding.swipeRefreshLayout.isVisible = isLoading
//                binding.progressBar.isVisible = isLoading
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        GlobalScope.launch {
            withContext(Dispatchers.IO + NonCancellable) {
                Glide.get(requireContext()).clearDiskCache()
            }
        }
        activity?.finish()
    }

    private fun initViews() {
        with(binding) {
            recyclerOfGames.adapter = easyAdapter
        }
    }

    private fun onGamesItemClicked(gamesDerails: GamesData) {
        val fragment = InfoGameFragment.newInstance(gamesDerails)
        parentFragmentManager.findFragmentById(R.id.fragmentContainer).also {
            it?.hideAndAddFragment(
                addFragment = fragment,
                id = R.id.fragmentContainer
            )
        }
    }


}
//    private fun setupGameList() {
//        val adapter = GamesAdapterPaging()
//        val tryAgainAction: TryAgainAction = { adapter.retry() }
//
//        val footerAdapter = DefaultLoadStateAdapter(tryAgainAction)
//
//        val adapterWithLoadState = adapter.withLoadStateFooter(footerAdapter)
//
//        with(binding) {
//            recyclerOfGames.layoutManager = LinearLayoutManager(requireContext())
//            recyclerOfGames.adapter = adapterWithLoadState
//
//            (recyclerOfGames.itemAnimator as? DefaultItemAnimator)?.supportsChangeAnimations = false
//
//
//        }
//
//    }
