package com.example.space_task1.service

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.space_task1.R
import com.example.space_task1.service.model.Categories
import com.example.space_task1.service.model.Data
import com.example.space_task1.service.model.response.DataResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.utilities.view.*

class PAdapter(private val item: Data, private val context: Context,
               var itemCallBack: ((item: Categories) -> Unit)? = null):
        RecyclerView.Adapter<PAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.utilities, parent, false))
    }

    override fun getItemCount(): Int {
        return item.categories!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = item.categories!![position].name
        Picasso.get().load(item.categories[position].picture!!.thumbnailUrl).into(holder.pic)

        holder.itemView.utilities.setOnClickListener {
            itemCallBack?.invoke(item.categories[position])
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.utility_name
        val pic: ImageView = view.utility_image
    }
}