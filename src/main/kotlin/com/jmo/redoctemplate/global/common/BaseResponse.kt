package com.jmo.redoctemplate.global.common

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.ResponseEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BaseResponse<T>(
    val data: T,
    val status: Int,
    val message: String? = null
) {
    val entity: ResponseEntity<T>
        get() = ResponseEntity.status(status).body(data)
}