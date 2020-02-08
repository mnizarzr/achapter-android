package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import io.github.achapter.R
import io.github.achapter.model.BookFeed
import io.github.achapter.util.inflate
import kotlinx.android.synthetic.main.item_book_linear.view.*

class BookAdapter :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    interface OnItemClickCallback{
        fun onItemClicked(data: BookFeed)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    val listBooks: ArrayList<BookFeed> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_book_linear))

    override fun getItemCount(): Int = listBooks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBooks[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: BookFeed) {
            with(itemView) {
                imgCover.load(data.getImageUrl()) {
                    transformations(RoundedCornersTransformation(12f))
                }
                txtTitle.text = data.title
                txtPrice.text = data.price.toString()
                txtAuthor.text = data.authors.joinToString { "${it.name}" }
                setOnClickListener { onItemClickCallback?.onItemClicked(data) }
            }
        }
    }

}