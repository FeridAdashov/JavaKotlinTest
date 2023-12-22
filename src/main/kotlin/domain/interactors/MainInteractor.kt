package domain.interactors

import domain.entity.RequestResult
import domain.repositories.MainRepository
import ui.entity.NotificationsEntity

class MainInteractor(private val repository: MainRepository) : BaseInteractor() {

    suspend fun getNotifications(): RequestResult<NotificationsEntity> {
        return generateResult(repository.getNotifications())
    }
}