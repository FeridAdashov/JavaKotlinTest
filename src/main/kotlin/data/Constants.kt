package data

import java.net.HttpURLConnection

object Constants {
    var BASE_URL =
        if (false) "https://user-dev.legalist.az/api/" else "https://user.legalist.az/api/"

    const val COMMON_TAG = "TAG_USER_APP"

    const val UNKNOWN_ERROR = 0
    const val SOCKET_EXCEPTION = 1
    const val SOCKET_TIMEOUT_EXCEPTION = 2
    const val CONNECTION_EXCEPTION = 3
    const val WRONG_DATA_EXCEPTION = 4
    const val SSL_EXCEPTION = 5
    const val UNAUTHORIZED_EXCEPTION = HttpURLConnection.HTTP_UNAUTHORIZED
    const val BAD_REQUEST = HttpURLConnection.HTTP_BAD_REQUEST
    const val NOT_FOUND = HttpURLConnection.HTTP_NOT_FOUND
}