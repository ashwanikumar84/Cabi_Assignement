package com.ashwani.cabiassignment.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://datausa.io/api/"

    val retrofitClient: Retrofit.Builder by lazy{

        val logging = HttpLoggingInterceptor()
        logging.setLevel(NONE)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: CabiApiInterface by lazy{
        retrofitClient.build().create(CabiApiInterface::class.java)
    }
}