package io.github.achapter.data

import io.github.achapter.model.Promo

object PromoFactory {

    private val banners = arrayListOf(
        "https://image.freepik.com/free-vector/abstract-sale-promotion-banner-template_23-2148212111.jpg",
        "https://image.freepik.com/free-vector/abstract-sale-promotion-banner-template_52683-13897.jpg",
        "https://image.freepik.com/free-vector/abstract-sale-promotion-banner-template_52683-13680.jpg",
        "https://image.freepik.com/free-vector/abstract-sale-promotion-banner-template_23-2148210826.jpg"
    )

    private val text = arrayListOf("Diskon 50%", "Diskon 20%", "Buy 1 Get 2", "Penerbit Bentang diskon 10%")

    fun getPromos(count: Int): List<Promo> {
        val promos = mutableListOf<Promo>()
        repeat(count){
            val promo = Promo(it, text[it], banners[it])
            promos.add(promo)
        }
        return promos
    }

}