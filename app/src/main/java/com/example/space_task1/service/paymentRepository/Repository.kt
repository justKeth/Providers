package com.example.space_task1.service.paymentRepository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.space_task1.service.model.response.DataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    private var repository: Repository? = null
    private val retrofit = Retrofit.Builder().baseUrl("https://testapi.spacebank.ge/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var spaceApi: SpaceApi = retrofit.create(SpaceApi::class.java)

    fun getInstance(): Repository {
        if(repository==null) {
            repository = Repository()
        }
        return repository as Repository
    }

    fun getInfo(): MutableLiveData<DataResponse>{
        val liveData = MutableLiveData<DataResponse>()
        val call = spaceApi.getAllItems()

        call.enqueue(object : Callback<DataResponse> {
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.e("ERROR","OH MY EYES!")
            }
            override fun onResponse(Call: Call<DataResponse>, response: Response<DataResponse>) {
                liveData.value = response.body()
            }
        })
        return liveData
    }
}