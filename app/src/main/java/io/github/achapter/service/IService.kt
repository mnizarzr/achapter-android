package io.github.achapter.service

import io.github.achapter.service.response.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface IService {

    @FormUrlEncoded
    @POST("login")
    fun submitLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseLogin>

}