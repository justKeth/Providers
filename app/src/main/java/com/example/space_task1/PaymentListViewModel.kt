package com.example.space_task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space_task1.service.paymentRepository.Repository
import com.example.space_task1.service.model.response.DataResponse

class PaymentListViewModel : ViewModel() {
    private val pRepository: Repository = Repository().getInstance()
    private val pResponse: MutableLiveData<DataResponse> = pRepository.getInfo()

    fun getApiResponse(): LiveData<DataResponse> {
        return pResponse
    }

}
