package data.mappers

import com.legalist.userapp.data.dto.BaseResponse
import ui.entity.BaseEntity

open class BaseMapper {

    fun toBaseEntity(baseResponse: BaseResponse): BaseEntity {
        return BaseEntity(
            code = baseResponse.code,
            message = baseResponse.message,
        )
    }
}