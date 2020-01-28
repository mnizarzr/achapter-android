package io.github.achapter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.achapter.R
import io.github.achapter.model.Genre
import io.github.achapter.util.inflate
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: Genre)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val listGenres = ArrayList<Genre>()

    fun setData(items: ArrayList<Genre>) {
        listGenres.clear()
        listGenres.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_genre))

    override fun getItemCount(): Int = listGenres.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listGenres[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Genre) {
            with(itemView) {
                txtGenre.text = data.name
                setOnClickListener { onItemClickCallback?.onItemClicked(data) }
            }
        }
    }

}