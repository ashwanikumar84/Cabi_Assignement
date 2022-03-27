package com.ashwani.cabiassignment.retrofit

import com.ashwani.cabiassignment.model.Nations
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CabiApiInterface {

    @GET("data")
    fun getNations(@Query("drilldowns") drilldowns: String, @Query("measures") measures: String): Call<Nations>

}