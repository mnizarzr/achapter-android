package io.github.achapter.data

import io.github.achapter.data.model.Wishlist

object WishlistData {
    private val wishNama = arrayOf("Kata",
        "Bumi",
        "bintang")

    private val wishHarga = arrayOf("Rp. 80.000,-",
        "Rp. 80.000,-",
        "Rp. 80.000,-")

    private val wishPhoto = arrayOf("https://mizanstore.com/admin718/assets/img/com_cart/produk/kata.jpeg",
        "https://mizanstore.com/admin718/assets/img/com_cart/produk/covGRM-188.jpg",
        "https://mizanstore.com/admin718/assets/img/com_cart/produk/covGRM-1703.jpg")

    val listData: ArrayList<Wishlist>
        get() {
            val list = arrayListOf<Wishlist>()
            for (position in wishNama.indices) {
                val wish = Wishlist()
                wish.nama = wishNama[position]
                wish.harga = wishHarga[position]
                wish.photo = wishPhoto[position]
                list.add(wish)
            }
            return list
        }
}