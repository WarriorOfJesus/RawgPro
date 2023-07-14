package gw.gobpo2005.rawg.main_page.di

import androidx.room.Room
import gw.gobpo2005.rawg.common.di.InjectionModule
import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.db.database.AppDataBase
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepository
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepositoryImpl
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepositoryImpl
import gw.gobpo2005.rawg.main_page.repository.remote.GenresRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GenresRepositoryImpl
import gw.gobpo2005.rawg.main_page.ui.RawgViewModel
import gw.gobpo2005.rawg.utils.Constants
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
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
        singleOf(::GamesRemoteRepositoryImpl) bind GamesRemoteRepository::class
        single { get<AppDataBase>().getGamesDao() }
        single { get<AppDataBase>().getGenresDao() }
        singleOf(::GamesLocalRepositoryImpl) bind GamesLocalRepository::class
        singleOf(::GenresRepositoryImpl) bind GenresRepository::class
        single(qualifier = named("io")) { Dispatchers.IO}
        single(qualifier = named("default")) { Dispatchers.Default}
        single{Dispatchers.Main}
        factory{MainPageInteractor(get(), get(), get())}
        factory{RawgViewModel(get(), get())}

    }
}