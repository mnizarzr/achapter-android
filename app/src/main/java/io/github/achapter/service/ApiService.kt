package io.github.achapter.service

import io.github.achapter.service.response.FeedResponse
import io.github.achapter.service.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun submitLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET
    fun getFeed() : Call<FeedResponse>

}