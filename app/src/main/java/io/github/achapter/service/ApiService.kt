package io.github.achapter.service

import io.github.achapter.service.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun submitRegister(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") username: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun submitLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("book/{id}")
    fun getBookDetail(@Path("id") id: Int): Call<BookDetailResponse>

    @GET("feed")
    fun getFeed(): Call<FeedResponse>

    @GET("genre")
    fun getGenres(): Call<GenreResponse>

    @GET("genre/{id}")
    fun getBookByGenre(@Path("id") id: Int): Call<BookByGenreResponse>

}