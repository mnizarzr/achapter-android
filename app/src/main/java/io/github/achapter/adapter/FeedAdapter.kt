package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.achapter.R
import io.github.achapter.util.inflate
import io.github.achapter.model.Feed
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter(private val feeds: List<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

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
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = FeedItemAdapter(feed.data)
                    setRecycledViewPool(viewPool)
                }
            }
        }
    }

}