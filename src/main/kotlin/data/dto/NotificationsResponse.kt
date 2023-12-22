package data.dto

import com.google.gson.annotations.SerializedName
import com.legalist.userapp.data.dto.BaseResponse

data class NotificationsResponse(
    @field:SerializedName("body")
    val body: NotificationBody? = null,
) : BaseResponse() {
    data class NotificationBody(
        @field:SerializedName("pageCount")
        val pageCount: Int? = null,

        @field:SerializedName("count")
        val count: Int? = null,

        @field:SerializedName("results")
        val notifications: List<Notification>? = null,
    )

    data class Notification(
        @field:SerializedName("id")
        val id: Int?,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("readStatus")
        val readStatus: Boolean? = null,

        @field:SerializedName("label")
        val label: String?,

        @field:SerializedName("message")
        val message: String?,

        @field:SerializedName("createdAt")
        val createdAt: String? = null,
    )
}

