package io.github.achapter.service

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "http://192.168.1.100:8000/api/"

    private var retrofit: Retrofit? = null

    private fun getOkHttpClient(token: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                chain.proceed(newRequest)
            }.build()
    }

    fun getClient(token: String = ""): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
//                .client(getOkHttpClient(token))
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

}