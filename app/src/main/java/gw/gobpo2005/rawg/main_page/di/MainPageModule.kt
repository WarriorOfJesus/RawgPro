package gw.gobpo2005.rawg.main_page.di

import androidx.room.Room
import gw.gobpo2005.rawg.common.di.InjectionModule
import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.db.database.AppDataBase
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepository
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import gw.gobpo2005.rawg.main_page.repository.remote.GameRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepositoryImpl
import gw.gobpo2005.rawg.main_page.ui.RawgViewModel
import gw.gobpo2005.rawg.utils.Constants
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainPageModule : InjectionModule {
    override fun onCreate() = module {
        single {
            Room.databaseBuilder(get(), AppDataBase::class.java, Constants.DATA_BASE_NAME)
                .build()
        }
        single { get<Retrofit>().create(RawgApi::class.java) }
        singleOf(::GamesRemoteRepositoryImpl) bind GameRepository::class
        single { get<AppDataBase>().getGamesDao() }
        singleOf(::GamesLocalRepositoryImpl) bind GamesLocalRepository::class
        factoryOf(::MainPageInteractor)
        factoryOf(::RawgViewModel)

    }
}