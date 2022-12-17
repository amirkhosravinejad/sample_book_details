package com.example.bookreader.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookreader.R
import com.example.bookreader.model.Book

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Book>,
    private val onitemListener: OnItemListener
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View, onItem: OnItemListener)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        val bookImage: ImageView = view.findViewById(R.id.bookCover)
        val bookNameText: TextView = view.findViewById(R.id.bookNameTextView)
        val authorText: TextView = view.findViewById(R.id.authorTextView)
        private val onItemSelect = onItem
        val vi = view.setOnClickListener(this)
        override fun onClick(p0: View?) {
            onItemSelect.onItemClicked(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout, onitemListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bookImage.setImageDrawable(context.resources.getDrawable(item.imageById))
        holder.bookNameText.text = context.resources.getString(item.nameById)
        holder.authorText.text = context.resources.getString(item.authorNameById)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    // use the interface to capture which item is selected
    // and used in activity or fragment which the recyclerView is.
    interface OnItemListener{
        fun onItemClicked(position: Int)
    }
}