package gw.gobpo2005.rawg.main_page.paging

//@OptIn(ExperimentalPagingApi::class)
//class MainPageRemoteMediator(
//    private val onLoadGames: suspend (page: Int) -> GamesFullData,
//    private val onSaveGames: (games: List<GamesData>) -> Unit,
//    private val dataBase: AppDataBase,
//    private val rawgApi: RawgApi,
//) : RemoteMediator<Int, GamesEntity>() {
    //    override suspend fun initialize(): InitializeAction {
//        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
//        return if (System.currentTimeMillis() - db.lastUpdated() <= cacheTimeout)
//        {
//            // Cached data is up-to-date, so there is no need to re-fetch
//            // from the network.
//            InitializeAction.SKIP_INITIAL_REFRESH
//        } else {
//            // Need to refresh cached data from network; returning
//            // LAUNCH_INITIAL_REFRESH here will also block RemoteMediator's
//            // APPEND and PREPEND from running until REFRESH succeeds.
//            InitializeAction.LAUNCH_INITIAL_REFRESH
//        }
//        return InitializeAction.LAUNCH_INITIAL_REFRESH
//    }
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, GamesEntity>
//    ): MediatorResult {
//
//        return try {
//            val loadKey = when(loadType){
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND ->  return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if(lastItem == null){
//                        1
//                    }else{
//                        (lastItem.id / state.config.pageSize) + 1
//                    }
//                }
//            }

//            val data = rawgApi.getListOfGame(
//                page = loadKey,
//                pageSize = state.config.pageSize,
//                genres = ""
//            )
//
//            dataBase.withTransaction {
//                if(loadType == LoadType.REFRESH){
//                    dataBase.daoGames.clearAll()
//                }
//                val gamesEntities = data.results.map { it.toGamesEntity() }
//                dataBase.daoGames.upsertAll(gamesEntities)
//            }
//                val gamesResult = data.results
//            MediatorResult.Success(
//                endOfPaginationReached = gamesResult.isEmpty()
//            )
//        } catch (e: IOException){
//            MediatorResult.Error(e)
//        }catch (e: HttpException){
//            MediatorResult.Error(e)
//        }
//    }
//        return try {
//            Timber.d("___$loadType")
//            val page = when (loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND ->
//                    return MediatorResult.Success(endOfPaginationReached = true)
//                LoadType.APPEND -> {
//                    Timber.d("___${state.anchorPosition}")
//                    val nextPage = state.closestPageToPosition(
//                        state.anchorPosition ?: return MediatorResult.Success(
//                            endOfPaginationReached = true
//                        )
//                    )?.nextKey ?: 1
//                    Timber.d("___$nextPage")
//                    nextPage
//                }
//            }
//
//            val data = onLoadGames(page)
//            Timber.d("___data = $data")
//            onSaveGames(data.result)
//            MediatorResult.Success(
//                endOfPaginationReached = data.next == null
//            )
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        } catch (e: HttpException) {
//            MediatorResult.Error(e)
//        }
//    }
//}