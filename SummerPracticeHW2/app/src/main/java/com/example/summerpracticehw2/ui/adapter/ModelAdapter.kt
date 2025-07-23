package com.example.summerpracticehw2.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpracticehw2.R
import com.example.summerpracticehw2.data.Model

class ModelAdapter(
    private var models: MutableList<Model>,
    private val imageResIds: List<Int>
) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleView: TextView = itemView.findViewById(R.id.titleView)
        val descriptionView: TextView = itemView.findViewById(R.id.descriptionView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        var model = models[position]

        holder.imageView.setImageResource(model.imageResId)
        holder.titleView.text = model.title
        holder.descriptionView.text = model.description

        holder.imageView.setOnClickListener {
            val newImageResId = imageResIds.random()
            model = model.copy(imageResId = newImageResId)
            models[position] = model
            holder.imageView.setImageResource(newImageResId)
        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            Intent(context, DetailActivity::class.java).apply {
                putExtra("title", model.title)
                putExtra("description", model.description)
                putExtra("imageResId", model.imageResId)
                context.startActivity(this)
            }
        }
    }

    override fun getItemCount(): Int = models.size
}