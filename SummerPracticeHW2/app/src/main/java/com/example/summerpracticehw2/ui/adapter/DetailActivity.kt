package com.example.summerpracticehw2.ui.adapter

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.summerpracticehw2.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.detailImageView)
        val titleView: TextView = findViewById(R.id.detailTitleView)
        val descriptionView: TextView = findViewById(R.id.detailDescriptionView)

        val title = intent.getStringExtra("title") ?: "Нет заголовка"
        val description = intent.getStringExtra("description") ?: "Нет описания"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.image1)

        imageView.setImageResource(imageResId)
        titleView.text = title
        descriptionView.text = description
    }
}
