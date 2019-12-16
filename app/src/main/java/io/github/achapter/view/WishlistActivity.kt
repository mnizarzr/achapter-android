package io.github.achapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.achapter.R
import io.github.achapter.adapter.WishlistAdapter
import io.github.achapter.data.WishlistData
import io.github.achapter.data.model.Wishlist
import kotlinx.android.synthetic.main.activity_wishlist.*

class WishlistActivity : AppCompatActivity() {

    private var list: ArrayList<Wishlist> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        rvWishlist.setHasFixedSize(true)

        list.addAll(WishlistData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvWishlist.layoutManager = LinearLayoutManager(this)
        val listWishAdapter = WishlistAdapter(this, list)
        rvWishlist.adapter = listWishAdapter
    }
}
