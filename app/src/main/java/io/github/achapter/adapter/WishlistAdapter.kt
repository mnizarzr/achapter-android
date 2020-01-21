package io.github.achapter.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import io.github.achapter.R
import io.github.achapter.model.WishList
import io.github.achapter.util.inflate
import kotlinx.android.synthetic.main.item_wishlist.view.*

class WishlistAdapter(private val context: Context, private val listWishes: ArrayList<WishList>) :
    RecyclerView.Adapter<WishlistAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder =
        ListViewHolder(viewGroup.inflate(R.layout.item_wishlist))

    override fun getItemCount(): Int {
        return listWishes.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listWishes[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(wishlist: WishList) {
            with(itemView) {
                txtWishNama.text = wishlist.nama
                txtWishHarga.text = wishlist.harga
                imgWish.load(wishlist.photo) {
                    transformations(RoundedCornersTransformation(12f))
                }
            }
        }
    }

}
