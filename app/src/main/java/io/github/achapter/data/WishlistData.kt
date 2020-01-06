package io.github.achapter.data

import io.github.achapter.model.WishList

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

    val listData: ArrayList<WishList>
        get() {
            val list = arrayListOf<WishList>()
            for (position in wishNama.indices) {
                val wish = WishList()
                wish.nama = wishNama[position]
                wish.harga = wishHarga[position]
                wish.photo = wishPhoto[position]
                list.add(wish)
            }
            return list
        }
}