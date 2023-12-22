package data.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {

    private val token = "3bGll7KpEkCKCRxQJFh8M346cTCc8IbR"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()

        val isMultiPartContent = request.headers["isMultiPartContent"] == "true"

        requestBuilder.apply {
            addHeader("App-Token", token)
            addHeader(
                "Content-Type",
                if (isMultiPartContent) "multipart/form-data" else "application/json"
            )
        }
        return chain.proceed(requestBuilder.build())
    }
}

