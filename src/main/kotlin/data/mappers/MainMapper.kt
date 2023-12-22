package data.mappers

import data.dto.NotificationsResponse
import ui.entity.NotificationsEntity

class MainMapper : BaseMapper() {


    fun toNotificationsEntity(res: NotificationsResponse): NotificationsEntity {
        return NotificationsEntity(
            code = res.code,
            message = res.message,
            pageCount = res.body?.pageCount,
            count = res.body?.count,
            notifications = res.body?.notifications?.map {
                NotificationsEntity.NotificationEntity(
                    id = it.id,
                    readStatus = it.readStatus,
                    label = it.label,
                    message = it.message,
                    createdAt = it.createdAt
                )
            }
        )
    }
}