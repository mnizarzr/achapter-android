package io.github.achapter.data

import io.github.achapter.model.BookDisplay
import java.util.*

//object FeedItemFactory {
//
//    private val books=  arrayListOf(
//        BookDisplay(1,"Sapiens", 125000, "https://images-na.ssl-images-amazon.com/images/I/71fsQxIlggL.jpg", 0),
//        BookDisplay(2,"Sebuah Seni Untuk Bersikap Bodo Amat", 67000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/sebuah-seni-untuk-bersikap-bodo-amat.jpg", 0),
//        BookDisplay(3,"Dunia Sophie", 100000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/covUD-214.jpg", 0),
//        BookDisplay(4,"Fields of Blood", 10000, "https://inc.mizanstore.com/aassets/img/com_cart/produk/covUD-161.jpg", 0),
//        BookDisplay(5,"Allah Tidak Cerewet Seperti Kita", 50000, "https://mizanstore.com/admin718/assets/img/com_cart/produk/allah-tidak-cerewet-seperti-kita-pre-order.jpg", 0)
//    )
//
//    private fun randomBook() : BookDisplay{
//        val index = Random().nextInt(books.size)
//        return books[index]
//    }
//
//    fun getChildren(count : Int) : ArrayList<BookDisplay>{
//        val children = mutableListOf<BookDisplay>()
//        repeat(count){
//            children.add(randomBook())
//        }
//        return children
//    }
//
//}