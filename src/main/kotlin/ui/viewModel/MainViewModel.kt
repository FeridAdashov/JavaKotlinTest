package ui.viewModel

import domain.interactors.MainInteractor
import kotlinx.coroutines.Job


class MainViewModel(private val mainInteractor: MainInteractor) : BaseViewModel() {

    private var mNotificationsJob: Job? = null

   suspend fun f() = mainInteractor.getNotifications()

    fun getNotifications() {
        mNotificationsJob?.cancel()
        mNotificationsJob = sendRequest({ mainInteractor.getNotifications() }, {
//            notificationsLiveData.postValue(it)
        })
    }
}