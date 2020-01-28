package io.github.achapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.achapter.model.Genre
import io.github.achapter.service.ApiClient
import io.github.achapter.service.ApiService
import io.github.achapter.service.response.GenreResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GenreViewModel : ViewModel() {

    private val service: ApiService = ApiClient.getService()

    private val listGenres = MutableLiveData<ArrayList<Genre>>()

    internal fun setGenres() {
        service.getGenres().enqueue(object : Callback<GenreResponse> {
            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                Timber.d(t.message)
            }

            override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {
                response.body()?.let {
                    listGenres.postValue(it.data)
                }
            }
        })
    }

    internal fun getGenres(): LiveData<ArrayList<Genre>> = listGenres

}