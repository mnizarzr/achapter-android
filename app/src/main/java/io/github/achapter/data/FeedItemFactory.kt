package io.github.achapter.data

import io.github.achapter.R
import io.github.achapter.model.BookDisplay
import java.util.*

object FeedItemFactory {

    private val books=  arrayListOf(
        BookDisplay("Sapiens", 125000, "https://images-na.ssl-images-amazon.com/images/I/71fsQxIlggL.jpg", 0),
        BookDisplay("Sebuah Seni Untuk Bersikap Bodo Amat", 67000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/sebuah-seni-untuk-bersikap-bodo-amat.jpg", 0),
        BookDisplay("Dunia Sophie", 100000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/covUD-214.jpg", 0),
        BookDisplay("Fields of Blood", 10000, "https://inc.mizanstore.com/aassets/img/com_cart/produk/covUD-161.jpg", 0),
        BookDisplay("Allah Tidak Cerewet Seperti Kita", 50000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/allah-tidak-cerewet-seperti-kita-pre-order.jpg", 0)
    )

    private fun randomBook() : BookDisplay{
        val index = Random().nextInt(books.size)
        return books[index]
    }

    fun getChildren(count : Int) : List<BookDisplay>{
        val children = mutableListOf<BookDisplay>()
        repeat(count){
            children.add(randomBook())
        }
        return children
    }

}