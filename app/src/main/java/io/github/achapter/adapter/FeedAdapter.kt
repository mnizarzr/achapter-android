package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.achapter.R
import io.github.achapter.model.BookDisplay
import io.github.achapter.model.Feed
import io.github.achapter.util.StartSnapHelper
import io.github.achapter.util.inflate
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter(private val feeds: List<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: BookDisplay)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_feed))

    override fun getItemCount(): Int = feeds.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feeds[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(feed: Feed) {
            with(itemView) {
                txtFeedTitle.text = feed.title
                rvItem.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                    addItemDecoration(SpacingItemDecoration(8, SpacingItemDecoration.HORIZONTAL))
                    adapter = FeedItemAdapter(feed.data, onItemClickCallback)
                    setRecycledViewPool(viewPool)
                }
                StartSnapHelper().attachToRecyclerView(rvItem)
            }
        }
    }

}