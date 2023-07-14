package gw.gobpo2005.rawg.main_page.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentListOfGamesBinding
import gw.gobpo2005.rawg.main_page.ui.adapter.*
import gw.gobpo2005.rawg.main_page.ui.model.ParentGenresDataUi
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import gw.gobpo2005.rawg.utils.navigation.replace
import gw.gobpo2005.rawg.utils.viewbinding.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class ListOfGamesFragment : BaseFragment(R.layout.fragment_list_of_games) {

    private val viewModel: RawgViewModel by viewModel()
    private val binding: FragmentListOfGamesBinding by viewBinding()

    private lateinit var mainLoadStateHolder: DefaultLoadStateAdapter.Holder

    companion object {
        fun newInstance(data: ResultDataUi) = InfoGameFragment().apply {
            arguments = bundleOf(Constants.LIST_OF_GAMES to data)
        }
    }


//    private val adapter: GamesAdapter by lazy {
//        GamesAdapter()
//    }

    private val parentAdapter: GenresAdapter by lazy {
        GenresAdapter(clickOnGame =  { item ->
            replace(InfoGameFragment.newInstance(item))
        }, onLoadGames = {
            viewModel.getGamesData(it)
        })
    }


    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mParentList = mutableListOf<ParentGenresDataUi>()
//        viewModel.getGamesData()
//        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        with(binding) {
            recyclerOfGames.adapter = parentAdapter
            recyclerOfGames.layoutManager = layoutManager
        }
        setObservers()
//        setupGameList()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.recyclerOfGames.layoutManager = null
        activity?.finish()
    }


    private fun setObservers() {
        with(viewModel) {
            observeNullable(gamesData) { games ->
                Timber.i("___setObservers")
                if (games != null) {
                    parentAdapter.setGames(games)
                }
            }
            observe(genresData) { genres ->
                showDataGenres(genres)
            }
        }
    }


    private fun showDataGenres(data: List<ParentGenresDataUi>) {
        parentAdapter.setGenres(data)
    }


    private fun setupGameList() {
        val adapter = GamesAdapterPaging()
        val tryAgainAction: TryAgainAction = { adapter.retry() }

        val footerAdapter = DefaultLoadStateAdapter(tryAgainAction)

        val adapterWithLoadState = adapter.withLoadStateFooter(footerAdapter)

        with(binding) {
            recyclerOfGames.layoutManager = LinearLayoutManager(requireContext())
            recyclerOfGames.adapter = adapterWithLoadState

            (recyclerOfGames.itemAnimator as? DefaultItemAnimator)?.supportsChangeAnimations = false

            mainLoadStateHolder = DefaultLoadStateAdapter.Holder(
                loadStateView,
                swipeRefreshLayout,
                tryAgainAction
            )

//            observeGames(adapter)
            observeLoadState(adapter)

        }

    }

//    private fun observeGames(adapter: GamesAdapterPaging) {
//        lifecycleScope.launch {
//            viewModel.gamesFlow.collectLatest { pagingData ->
//                Timber.d("$pagingData")
//                adapter.submitData(pagingData)
//            }
//        }
//    }

    private fun observeLoadState(adapter: GamesAdapterPaging) {
        lifecycleScope.launch {
            adapter.loadStateFlow.debounce(200).collectLatest { state ->
                mainLoadStateHolder.onBind(state.refresh)
            }
        }
    }
}