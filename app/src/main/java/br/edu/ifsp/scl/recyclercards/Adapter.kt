package br.edu.ifsp.scl.recyclercards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class Adapter(private val items: List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.run {
        items[position].let {
            imageView.setImageResource(it.image)
            titleTextView.text = it.title
            descriptionTextView.text = it.description
        }
    }

    data class ViewHolder(
        val itemView: View,
        val imageView: ImageView = itemView.imageView,
        val titleTextView: TextView = itemView.titleTextView,
        val descriptionTextView: TextView = itemView.descriptionTextView
    ) : RecyclerView.ViewHolder(itemView)
}