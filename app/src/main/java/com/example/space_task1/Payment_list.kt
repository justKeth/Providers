package com.example.space_task1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.space_task1.service.PAdapter
import kotlinx.android.synthetic.main.payment_list_fragment.*

class Payment_list : Fragment(R.layout.payment_list_fragment) {

    private lateinit var viewModel: PaymentListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PaymentListViewModel::class.java)
        viewModel.getApiResponse().observe(this, Observer { response ->
            text_id.text = response.data.categories!![0].name

            recycler_view_id.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = PAdapter(response.data, context)
            }
        })
    }

//    fun initUi(pResponse: DataResponse){
//        utility_name.text = pResponse.data.categories?.
//    }

}
