package com.example.space_task1.service.paymentRepository

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.space_task1.R
import com.example.space_task1.service.model.Company
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.utiliti_one_layout.view.*

class CAdapter (val companies: MutableList<Company>?, private val context: Context):
    RecyclerView.Adapter<CAdapter.ViewHolder>() {
//    private var filteredList: List<Company> = ArrayList<Company>(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.utiliti_one_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return companies!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name1.text = companies!![position].name
        Picasso.get().load(companies[position].picture!!.thumbnailUrl).into(holder.pic)

        holder.itemView.utiliti_one_layout.setOnClickListener {view ->
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name1: TextView = view.utility_one_name
        val pic : ImageView = view.utility_one_image
    }
}