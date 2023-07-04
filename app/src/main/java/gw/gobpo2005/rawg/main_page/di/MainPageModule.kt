package gw.gobpo2005.rawg.main_page.di

import gw.gobpo2005.rawg.common.di.InjectionModule
import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.interactor.Interactor
import org.koin.core.module.dsl.factoryOf
import gw.gobpo2005.rawg.main_page.repository.remote.GameRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepository
import gw.gobpo2005.rawg.main_page.ui.RawgViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainPageModule : InjectionModule {
    override fun onCreate() = module {
        single { get<Retrofit>().create(RawgApi::class.java) }
        singleOf(::GamesRemoteRepository) bind GameRepository::class
        factoryOf(:: Interactor)
        factoryOf(::RawgViewModel)

    }
}