package domain.repositories

import ui.entity.NotificationsEntity

interface MainRepository {

    /**
     * Get all notifications
     */
    suspend fun getNotifications(): NotificationsEntity

}