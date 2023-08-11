package gw.gobpo2005.rawg.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gw.gobpo2005.rawg.R
import gw.gobpo2005.rawg.databinding.ActivityMainBinding
import gw.gobpo2005.rawg.main_page.ui.ListOfGamesFragment
import gw.gobpo2005.rawg.utils.navigation.replace


class RootActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replace(ListOfGamesFragment(), containerId = R.id.fragmentContainer)
    }
}
