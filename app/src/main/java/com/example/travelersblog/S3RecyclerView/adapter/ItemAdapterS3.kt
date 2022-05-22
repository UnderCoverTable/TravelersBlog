package com.example.travelersblog.S3RecyclerView.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info


class ItemAdapterS3 (private val dataset: MutableList<Info>
) : RecyclerView.Adapter<ItemAdapterS3.ItemViewHolder>() {

    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imagePlace: ImageView = view.findViewById(R.id.s3image)
        val textTitle : TextView = view.findViewById(R.id.s3title)
        val textDescription : TextView = view.findViewById(R.id.s3decription)
        val textAuthor : TextView = view.findViewById(R.id.s3author)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.s3_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imagePlace.setImageResource(item.imageResourceId)
        holder.textTitle.text = item.place
        holder.textDescription.text = item.shortDesc
        holder.textAuthor.text = item.author


    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}