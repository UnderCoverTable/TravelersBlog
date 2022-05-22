package com.example.travelersblog.S3RecyclerView.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.travelersblog.R
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.S6BlogPage
import com.google.android.material.card.MaterialCardView
import java.io.File


class ItemAdapterS3 (private val guest: Boolean, private val author: String, private val dataset: MutableList<Info>
) : RecyclerView.Adapter<ItemAdapterS3.ItemViewHolder>() {
    companion object{
        var s6Image = 0
        var S6Title = ""
        var S6ShortDesc = ""
        var s6LongDesc = ""
        var s6Author = ""
    }

    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imagePlace: ImageView = view.findViewById(R.id.s3image)
        val textTitle : TextView = view.findViewById(R.id.s3title)
        val textDescription : TextView = view.findViewById(R.id.s3decription)
        val textAuthor : TextView = view.findViewById(R.id.s3author)
        val card : MaterialCardView = view.findViewById(R.id.cardButton)

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

        holder.card.setOnLongClickListener {
            if (item.author == author) {
                dataset.remove(item)
                deleteEntry(holder.view.context, item)
            } else {
                Toast.makeText(holder.view.context, "You can't delete this entry!", Toast.LENGTH_LONG).show()
            }
        }

        holder.card.setOnClickListener {
            val context = holder.view.context
            s6Image = item.imageResourceId
            S6Title = item.place
            S6ShortDesc = item.shortDesc
            s6LongDesc = item.longDesc
            s6Author = item.author

            val intent = Intent(context, S6BlogPage::class.java)
            intent.putExtra("author", author)
            intent.putExtra("guest", guest)
            context.startActivity(intent)
        }
    }

    private fun deleteEntry(context: Context, entry: Info) {
        val file = File(context.filesDir, "blog-db.txt")
        var data = file.readText()
        val toDelete = "${entry.imageResourceId}||${entry.place}||${entry.shortDesc}||${entry.longDesc}||${entry.author}"

        if (data.isNotEmpty()) {
            val splitData: MutableList<String> = data.split("\n") as MutableList<String>

            splitData.forEach {
                if (toDelete in it) {
                    splitData.remove(it)
                }
            }
            data = splitData.joinToString("\n")
            file.delete()
            file.createNewFile()
            file.appendText(data)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}