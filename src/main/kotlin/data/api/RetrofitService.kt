package data.api

import data.dto.NotificationsResponse
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitService {

    @GET("v1/notifications/")
    suspend fun getNotifications(): Response<NotificationsResponse>

}
