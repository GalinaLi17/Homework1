package com.example.summerpracticehw2.ui.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpracticehw2.R
import com.example.summerpracticehw2.utils.ModelGenerator

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val imageResIds = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6
        )

        val models = ModelGenerator.generateModels(6, imageResIds)
            .sortedBy { it.title }
            .toMutableList()

        adapter = ModelAdapter(models, imageResIds)
        recyclerView.adapter = adapter
    }
}
