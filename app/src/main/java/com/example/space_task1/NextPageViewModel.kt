package com.example.space_task1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.space_task1.service.model.Company
import com.example.space_task1.service.model.response.DataResponse
import com.example.space_task1.service.paymentRepository.Repository

class NextPageViewModel : ViewModel() {

    private val pRepository: Repository = Repository().getInstance()
    private val pResponse: MutableLiveData<DataResponse> = pRepository.getInfo()
    private val companiesList: MutableLiveData<MutableList<Company>> = MutableLiveData()

    fun get() : LiveData<MutableList<Company>> {
        return companiesList
    }

    fun set(items: MutableList<Company>) {
        companiesList.value = items
    }

    fun getApiResponse(): LiveData<DataResponse> {
        return pResponse
    }
}
