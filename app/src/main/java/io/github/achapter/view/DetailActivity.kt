package io.github.achapter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import coil.transform.RoundedCornersTransformation
import io.github.achapter.R
import io.github.achapter.model.BookDetail
import io.github.achapter.service.ApiClient
import io.github.achapter.service.ApiService
import io.github.achapter.service.response.BookDetailResponse
import io.github.achapter.util.PreferenceHelper
import io.github.achapter.util.hide
import io.github.achapter.util.show
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_book.imgBookCover
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BOOK_ID = "EXTRA_BOOK_ID"
    }

    private lateinit var data: BookDetail
    private var apiService: ApiService = ApiClient.getService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(EXTRA_BOOK_ID, 0)

        progressBar.show()
        getBookDetail(id)

    }

    private fun getBookDetail(id: Int) {
        if (id > 0) apiService.getBookDetail(id).enqueue(object : Callback<BookDetailResponse> {
            override fun onFailure(call: Call<BookDetailResponse>, t: Throwable) {
                Timber.e(t)
            }

            override fun onResponse(
                call: Call<BookDetailResponse>,
                response: Response<BookDetailResponse>
            ) {
                response.body()?.let {
                    data = it.data
                    
                    imgBookCover.load(data.getImageUrl()) {
                        transformations(RoundedCornersTransformation(12f))
                    }

                    txtTitle.text = data.title
                    txtAuthor.text = data.authors.joinToString { author -> "${author.name}" }
                    txtDiscount.text = data.discount.toString()
                    txtPrice.text = data.price.toString()
                    txtDesc.text = data.description
                }
                progressBar.hide()
            }

        })
    }

}
