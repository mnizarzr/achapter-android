package io.github.achapter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.achapter.R
import io.github.achapter.adapter.BookAdapter
import io.github.achapter.model.Genre
import io.github.achapter.service.ApiClient
import io.github.achapter.service.ApiService
import io.github.achapter.service.response.BookByGenreResponse
import io.github.achapter.util.PreferenceHelper
import kotlinx.android.synthetic.main.activity_feed_result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class FeedResultActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    private lateinit var resultViewModel: AndroidViewModel
    private lateinit var service: ApiService
    private lateinit var sharedPreference: PreferenceHelper
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_result)

        val data = intent.getParcelableExtra(EXTRA_DATA) as Genre
        sharedPreference = PreferenceHelper(this)
        service = ApiClient.getService(sharedPreference.getToken())

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = data.name
        }

        bookAdapter = BookAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

        service.getBookByGenre(data.id!!).enqueue(object : Callback<BookByGenreResponse> {
            override fun onFailure(call: Call<BookByGenreResponse>, t: Throwable) {
                Timber.d(t.message)
            }

            override fun onResponse(
                call: Call<BookByGenreResponse>,
                response: Response<BookByGenreResponse>
            ) {
                response.body()?.let {
                    bookAdapter.listBooks.addAll(it.data?.books!!)
                    bookAdapter.notifyDataSetChanged()
                }
            }
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
