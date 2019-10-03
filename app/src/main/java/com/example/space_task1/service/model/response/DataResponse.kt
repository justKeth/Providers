package com.example.space_task1.service.model.response

import com.example.space_task1.service.model.Data
import com.example.space_task1.service.model.Status

data class DataResponse(
    val data: Data,
    val status: Status
)