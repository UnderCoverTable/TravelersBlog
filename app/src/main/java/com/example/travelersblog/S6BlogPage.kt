package com.example.travelersblog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelersblog.S3RecyclerView.adapter.ItemAdapterS3
import com.example.travelersblog.S3RecyclerView.model.Info
import com.example.travelersblog.databinding.ActivityS3BlogEntriesBinding
import com.example.travelersblog.databinding.ActivityS6BlogPageBinding
import java.io.File

class S6BlogPage : AppCompatActivity() {

    lateinit var binding: ActivityS6BlogPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityS6BlogPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageView.setImageResource(ItemAdapterS3.s6Image)
        binding.s6Title.text = ItemAdapterS3.S6Title
        binding.s6ShortDesc.text = ItemAdapterS3.S6ShortDesc
        binding.s6Author.text = ItemAdapterS3.s6Author
        binding.s6LongDesc.text = ItemAdapterS3.s6LongDesc

        val guest = intent.getBooleanExtra("guest", true)
        val author = intent.getStringExtra("author")

        if (guest && author != ItemAdapterS3.s6Author) {
            binding.s6UpdateButton.isEnabled = false
        } else {
            binding.s6UpdateButton.setOnClickListener {
                val entry = Info(imageResourceId = binding.imageView.id.toInt(),
                                place = binding.s6Title.text.toString(),
                                shortDesc = binding.s6ShortDesc.text.toString(),
                                longDesc = binding.s6LongDesc.text.toString(),
                                author = author.toString())
                updateEntry(this, entry)
            }
        }
    }

    private fun updateEntry(context: Context, entry: Info) {
        val file = File(context.filesDir, "blog-db.txt")
        var data = file.readText()
        val toReplace = "${entry.imageResourceId}||${entry.place}||${entry.shortDesc}||${entry.longDesc}||${entry.author}"
        val original = "${ItemAdapterS3.S6Title}||${ItemAdapterS3.S6ShortDesc}||${ItemAdapterS3.s6LongDesc}||${ItemAdapterS3.s6Author}"

        if (data.isNotEmpty()) {
            val splitData: MutableList<String> = data.split("\n") as MutableList<String>
            var index = 0

            splitData.forEach {
                if (original in it) {
                   index = splitData.indexOf(it)
                }
            }
            splitData.removeAt(index)
            splitData.add(toReplace)
            data = splitData.joinToString("\n")
            file.delete()
            file.createNewFile()
            file.appendText(data)
        }
    }
}