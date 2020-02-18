package io.github.achapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.achapter.model.Feed
import io.github.achapter.service.ApiClient
import io.github.achapter.service.ApiService
import io.github.achapter.service.response.FeedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class FeedViewModel : ViewModel() {

    private val service: ApiService = ApiClient.getService()

    private val listFeeds = MutableLiveData<ArrayList<Feed>>()

    internal fun setFeeds() {
        service.getFeed().enqueue(object : Callback<FeedResponse> {
            override fun onFailure(call: Call<FeedResponse>, t: Throwable) {
                Timber.e(t)
            }

            override fun onResponse(call: Call<FeedResponse>, response: Response<FeedResponse>) {
                response.body()?.let {
                    listFeeds.postValue(it.data)
                }
            }
        })
    }

    internal fun getFeeds(): LiveData<ArrayList<Feed>> = listFeeds

}