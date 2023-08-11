package gw.gobpo2005.rawg.common.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    fun <T : Any, F : Flow<T>> observe(flow: F, body: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) { flow.collect { body(it) } }
        }
    }

    fun <T : Any?, F : Flow<T?>> observeNullable(flow: F, body: (T?) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect { body(it) }
            }
        }
    }

    fun hideAndAddFragment(addFragment: Fragment, id: Int) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
            .hide(this)
            .add(id, addFragment)
            .commit()
    }

    abstract fun initViews()

    abstract fun bind()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bind()
    }
}
