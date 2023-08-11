package gw.gobpo2005.rawg

import android.app.Application
import gw.gobpo2005.rawg.common.di.NetworkModule
import gw.gobpo2005.rawg.main_page.di.MainPageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setTimber()
        setupKoin()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    NetworkModule.onCreate(),
                    MainPageModule.onCreate()
                )
            )
        }
    }
}
