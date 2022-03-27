package com.ashwani.cabiassignment.retrofit

import com.ashwani.cabiassignment.model.Nations
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface WebServices {

    @GET("data")
    fun getNations(@Query("Nation") drilldowns: String, @Query("Population") measures: String): Call<List<Nations>>



    companion object {
        var webServices: WebServices? = null

        fun getInstance(): WebServices {
            if (webServices == null) {
                val webServices = Retrofit.Builder()
                    .baseUrl("https://datausa.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                webServices.create(WebServices::class.java)
            }
            return webServices!!
        }
    }
}
