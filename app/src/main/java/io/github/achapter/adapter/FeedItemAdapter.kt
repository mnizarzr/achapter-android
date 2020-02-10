package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import io.github.achapter.R
import io.github.achapter.util.inflate
import io.github.achapter.model.BookDisplay
import kotlinx.android.synthetic.main.item_book.view.*

class FeedItemAdapter(
    private val items: List<BookDisplay>,
    private val onItemClickCallback: FeedAdapter.OnItemClickCallback?
) :
    RecyclerView.Adapter<FeedItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_book))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookDisplay) {
            with(itemView) {
                txtBookTitle.text = book.title
                txtBookPrice.text = String.format("Rp. %d", book.price)
                imgBookCover.load(book.cover) {
                    transformations(RoundedCornersTransformation(12f))
                }
                setOnClickListener { onItemClickCallback?.onItemClicked(book) }
            }
        }
    }

}