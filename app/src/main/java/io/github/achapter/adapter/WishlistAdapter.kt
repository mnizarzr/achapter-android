package io.github.achapter.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import io.github.achapter.R
import io.github.achapter.data.model.Wishlist

class WishlistAdapter(private val context: Context, private val listWish: ArrayList<Wishlist>) :
    RecyclerView.Adapter<WishlistAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_wishlist, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWish.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wish = listWish[position]
        holder.imgPhoto.load(wish.photo) {
            transformations(RoundedCornersTransformation(10f))
        }
        holder.tvNama.text = wish.nama
        holder.tvHarga.text = wish.harga
//        holder.itemView.setOnClickListener{
//            context.startActivity(Intent(context, DetailActivity::class.java))
//        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.txtWishNama)
        var tvHarga: TextView = itemView.findViewById(R.id.txtWishHarga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.imgWish)
    }

}
