package io.github.achapter.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.achapter.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "http://192.168.1.100:8000/api/"

    private var retrofit: Retrofit? = null

    private val gson: Gson
        get() {
            return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        }

    private fun getOkHttpClient(token: String): OkHttpClient {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                chain.proceed(newRequest)
            }

        if (BuildConfig.DEBUG) okHttp.addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        return okHttp.build()
    }

    private fun createRetrofitInstance(token: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(getOkHttpClient(token))
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit!!
    }

    fun getService(token: String = ""): ApiService = createRetrofitInstance(token).create(ApiService::class.java)

}