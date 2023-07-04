package gw.gobpo2005.rawg.main_page.ui.model

import gw.gobpo2005.rawg.main_page.model.ResultData

object ConverterUi {

    fun fromNetwork(response: List<ResultData>): List<ResultDataUi> {
        return response.map { data ->
            ResultDataUi(
                name = data.name ?: "",
                image = data.backgroundImage ?: ""
            )
        }
    }
}