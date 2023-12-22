package ui.viewModel


import com.legalist.userapp.data.Constants
import domain.entity.RequestResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ui.entity.BaseEntity

open class BaseViewModel {

    fun <T> sendRequest(
        call: suspend () -> RequestResult<T>,
        getData: (RequestResult<T>) -> Unit
    ): Job {
        return CoroutineScope(Dispatchers.IO).launch {
            getData.invoke(call.invoke())
        }
    }

    fun getErrorMessage(info: BaseEntity): String {
        return when (info.code) {
            Constants.SOCKET_EXCEPTION -> info.message ?: "Error happened"
            Constants.SOCKET_TIMEOUT_EXCEPTION -> "timeout_exception"
            Constants.UNKNOWN_ERROR -> info.message ?: "unknown_error"
            Constants.CONNECTION_EXCEPTION -> "check_internet_connection"
            Constants.UNAUTHORIZED_EXCEPTION -> info.message ?: "user_not_found"
            Constants.WRONG_DATA_EXCEPTION -> "data_parse_error"
            Constants.SSL_EXCEPTION -> "ssl_exception"
            Constants.BAD_REQUEST -> info.message ?: "have_troubles"
            Constants.NOT_FOUND -> info.message ?: "data_not_found"
            else -> info.message ?: "have_troubles"
        }
    }
}