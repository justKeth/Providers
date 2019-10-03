package com.example.space_task1.service.paymentRepository


import com.example.space_task1.service.model.response.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface SpaceApi {
    @GET("payments/categories")
    fun getAllItems(): Call<DataResponse>
}
