package gw.gobpo2005.rawg.main_page.ui.model

data class ParentGenresDataUi(
    val id : Int,
    val nameGenres : String,
    val image : String,
    val listOfGames : List<ResultDataUi>
)