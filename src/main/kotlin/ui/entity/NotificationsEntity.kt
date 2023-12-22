package ui.entity

class NotificationsEntity(
    code: Int,
    message: String? = null,
    pageCount: Int? = null,
    count: Int? = null,
    val notifications: List<NotificationEntity>? = null
) : BaseEntity(code, message) {
    data class NotificationEntity(
        val id: Int? = null,
        val readStatus: Boolean? = null,
        val label: String? = null,
        val message: String? = null,
        val createdAt: String? = null,
    )
}