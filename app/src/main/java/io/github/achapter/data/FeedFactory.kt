package io.github.achapter.data

import io.github.achapter.model.BookDisplay
import io.github.achapter.model.Feed
import java.util.*
import kotlin.collections.ArrayList

//object FeedFactory {
//
//    private val titles =  arrayListOf("Popular Books", "Best Seller", "New Release", "Promo")
//
//    private fun randomTitle() : String{
//        val index = Random().nextInt(titles.size)
//        return titles[index]
//    }
//
//    private fun randomChildren() : ArrayList<BookDisplay>{
//        return FeedItemFactory.getChildren(20)
//    }
//
//    fun getFeeds(count : Int) : List<Feed>{
//        val parents = mutableListOf<Feed>()
//        repeat(count){
//            val parent = Feed(randomChildren(), randomTitle(), randomTitle())
//            parents.add(parent)
//        }
//        return parents
//    }
//
//}