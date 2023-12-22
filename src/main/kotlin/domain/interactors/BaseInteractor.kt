package domain.interactors

import domain.entity.RequestResult
import ui.entity.BaseEntity

open class BaseInteractor {

    fun <T : BaseEntity> generateResult(entity: T): RequestResult<T> {
        return if (entity.code in 200..202)
            RequestResult.Success(body = entity, code = entity.code)
        else RequestResult.Error(code = entity.code, message = entity.message ?: "")
    }
}