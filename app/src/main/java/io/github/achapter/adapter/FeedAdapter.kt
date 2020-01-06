package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.achapter.R
import io.github.achapter.extension.inflate
import io.github.achapter.model.BookDisplay
import io.github.achapter.model.Feed

class FeedAdapter(private val books: List<Any>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    companion object {
        const val ITEM_HEADER = 0
        const val ITEM_BOOK = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (books[position]) {
            is String -> ITEM_HEADER
            is Feed -> ITEM_BOOK
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_book))

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position] as BookDisplay)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(books: BookDisplay) {
            with(itemView) {

            }
        }
    }

}