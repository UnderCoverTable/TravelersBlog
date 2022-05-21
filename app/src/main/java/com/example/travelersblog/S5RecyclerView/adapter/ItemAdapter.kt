package com.example.travelersblog.S5RecyclerView.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelersblog.R
import com.example.travelersblog.S4NewEntry
import com.example.travelersblog.S5ImageList
import com.example.travelersblog.S5RecyclerView.model.Images


class ItemAdapter(
    private val dataset: List<Images>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Here, parent is the RecyclerView. Ignore viewType for now.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.s5_list_image_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }


    /**
     * holder is the ItemViewHolder object created by the onCreateViewHolder method
     * position is it's position in the RecyclerView, 0 based index.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)

        holder.imageView.setOnClickListener {
                val context = holder.view.context
                val intent = Intent(context, S4NewEntry::class.java)
                S5ImageList.imageID = item.imageResourceId
                context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}