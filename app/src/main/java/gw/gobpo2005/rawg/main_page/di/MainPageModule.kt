package gw.gobpo2005.rawg.main_page.di

import androidx.room.Room
import gw.gobpo2005.rawg.common.di.InjectionModule
import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.db.database.AppDataBase
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.repository.MainLocalRepository
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepositoryImpl
import gw.gobpo2005.rawg.main_page.repository.remote.MainRemoteRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepositoryImpl
import gw.gobpo2005.rawg.main_page.ui.RawgViewModel
import gw.gobpo2005.rawg.utils.Utils
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainPageModule : InjectionModule {
    override fun onCreate() = module {
        single {
            Room.databaseBuilder(get(), AppDataBase::class.java, Utils.DATA_BASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
        single { get<Retrofit>().create(RawgApi::class.java) }
        singleOf(::GamesRemoteRepositoryImpl) bind MainRemoteRepository::class
        single { get<AppDataBase>().getGamesDao() }
        single { get<AppDataBase>().getGenresDao() }
        singleOf(::GamesLocalRepositoryImpl) bind MainLocalRepository::class
        single(qualifier = named("io")) { Dispatchers.IO}
        single(qualifier = named("default")) { Dispatchers.Default}
        single{Dispatchers.Main}
        factory{MainPageInteractor(get(), get())}
        factory{RawgViewModel(get())}

    }
}