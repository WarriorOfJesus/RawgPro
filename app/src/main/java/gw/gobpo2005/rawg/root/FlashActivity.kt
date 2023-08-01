package gw.gobpo2005.rawg.root

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import gw.gobpo2005.rawg.R

class FlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, RootActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed( {
            startActivity(intent)
            finish()
        }, 3200)

    }

}
