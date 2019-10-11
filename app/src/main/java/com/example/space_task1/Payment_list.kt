package com.example.space_task1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.space_task1.service.PAdapter
import com.example.space_task1.service.model.Company
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

                adapter = PAdapter(response.data, context, itemCallBack = { data ->
                    val companyListFromCategory: MutableList<Company> = arrayListOf()
                    data.companyIds?.forEach { companyId ->
                        viewModel.getApiResponse().value?.data?.companies?.filter { it.companyId == companyId && it.parentId == data.categoryId}?.forEach {
                            companyListFromCategory.add(it)
                        }
                    }
                    findNavController().navigate(R.id.action_fragment_main_to_nextPage, bundleOf("companyListFromCategory" to companyListFromCategory))
                    Log.d("size of array", companyListFromCategory.size.toString())
                })
            }
        })
    }
}
