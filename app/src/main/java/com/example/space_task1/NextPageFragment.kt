package com.example.space_task1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.space_task1.service.model.Company
import com.example.space_task1.service.paymentRepository.CAdapter
import kotlinx.android.synthetic.main.fragment_next_page.*

class NextPageFragment : Fragment(R.layout.fragment_next_page) {

    private lateinit var viewModel: NextPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NextPageViewModel::class.java)


//        mobile_text_id.text = args!!.name


//        viewModel.getApiResponse().observe(this, Observer { response ->
//            mobile_text_id.text = args!!.name
//
//            mobile_recycler_view_id.apply {
//                layoutManager = LinearLayoutManager(context)
//
//                adapter = CAdapter(response.data, context)
//            }
//        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        companies_recycler_view_id.apply {
            layoutManager = LinearLayoutManager(context)

            adapter = CAdapter(arguments?.getParcelableArrayList<Company>("companyListFromCategory")?.toMutableList(), context)
        }
    }
}
