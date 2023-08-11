package gw.gobpo2005.rawg.details_page.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import gw.gobpo2005.rawg.R

class ScreenshotDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setContentView(R.layout.fragment_alone_screenshot)
        return dialog
    }
}
