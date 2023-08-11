package gw.gobpo2005.rawg.main_page.db.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import gw.gobpo2005.rawg.main_page.model.games.Platform
import gw.gobpo2005.rawg.main_page.model.games.PlatformContainer
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot

class DataBaseTypeConverters {

    private val gson: Gson = GsonBuilder().create()

    @TypeConverter
    fun fromListShortScreenshots(data: List<ShortScreenshot>?): String {
        val result = StringBuilder()
        data?.let {
            for (item in data) {
                result.append(gson.toJson(item))
                result.append(';')
            }
        }
        return result.toString()
    }

    @TypeConverter
    fun toListShortScreenshots(data: String): List<ShortScreenshot> {
        if (data.isEmpty()) return listOf()
        val result = mutableListOf<ShortScreenshot>()
        for (item in data.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            result.add(gson.fromJson(item, ShortScreenshot::class.java))
        }
        return result
    }

    @TypeConverter
    fun fromListParentPlatformContainer(data: List<PlatformContainer>?): String {
        val result = StringBuilder()
        data?.let {
            for (item in data) {
                result.append(gson.toJson(item))
                result.append(';')
            }
        }
        return result.toString()
    }

    @TypeConverter
    fun toListParentPlatformContainer(data: String): List<PlatformContainer> {
        if (data.isEmpty()) return listOf()
        val result = mutableListOf<PlatformContainer>()
        for (item in data.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            result.add(gson.fromJson(item, PlatformContainer::class.java))
        }
        return result
    }

    @TypeConverter
    fun fromParentPlatform(parentPlatform: Platform): String {
        return gson.toJson(parentPlatform)
    }

    @TypeConverter
    fun toParentPlatform(data: String): Platform {
        return gson.fromJson(data, Platform::class.java)
    }

}
