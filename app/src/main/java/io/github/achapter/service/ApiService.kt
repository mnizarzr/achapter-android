package io.github.achapter.service

import io.github.achapter.service.response.BookByGenreResponse
import io.github.achapter.service.response.FeedResponse
import io.github.achapter.service.response.GenreResponse
import io.github.achapter.service.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun submitLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("feed")
    fun getFeed(): Call<FeedResponse>

    @GET("genre")
    fun getGenres(): Call<GenreResponse>

    @GET("genre/{id}")
    fun getBookByGenre(@Path("id") id: Int): Call<BookByGenreResponse>


}