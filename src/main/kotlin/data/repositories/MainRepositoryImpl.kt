package data.repositories

import com.google.gson.Gson
import data.ExceptionUtils
import data.api.RetrofitService
import data.dto.NotificationsResponse
import data.mappers.MainMapper
import domain.repositories.MainRepository
import ui.entity.NotificationsEntity

class MainRepositoryImpl(
    private val apiService: RetrofitService,
    private val mainMapper: MainMapper,
) : MainRepository {

    override suspend fun getNotifications(): NotificationsEntity {
        return try {
            val response = apiService.getNotifications()

            if (response.isSuccessful) {
                mainMapper.toNotificationsEntity(response.body()!!)
            } else {
                val errorResponse = Gson().fromJson(
                    response.errorBody()?.string(),
                    NotificationsResponse::class.java
                )
                mainMapper.toNotificationsEntity(errorResponse)
            }
        } catch (e: Exception) {
            return NotificationsEntity(
                code = ExceptionUtils.getExceptionCode(e),
                message = e.message
            )
        }
    }

}