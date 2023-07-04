package gw.gobpo2005.rawg.main_page.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.common.fragment.BaseFragment
import gw.gobpo2005.rawg.databinding.FragmentListOfGamesBinding
import gw.gobpo2005.rawg.main_page.ui.adapter.GamesAdapter
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class ListOfGamesFragment : BaseFragment(R.layout.fragment_list_of_games) {

    private val viewModel: RawgViewModel by viewModel()
    private val binding: FragmentListOfGamesBinding by viewBinding()

    private val adapter: GamesAdapter by lazy {
        GamesAdapter()
    }

    private lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGamesData()
        layoutManager = LinearLayoutManager(requireContext())
        with(binding) {
            recyclerOfGames.adapter = adapter
        }
        setObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.finish()
        binding.recyclerOfGames.layoutManager = null
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerOfGames.layoutManager = layoutManager
        Timber.i("__On start")
    }

    private fun setObservers() {
        with(viewModel) {
            observe(gamesData) { games ->
                Timber.i("___setObservers")
                showData(games)
            }
        }
    }

    private fun showData(data: List<ResultDataUi>) {
        adapter.setData(data)
    }
}