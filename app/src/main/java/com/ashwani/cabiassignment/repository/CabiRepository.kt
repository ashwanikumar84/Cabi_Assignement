package com.ashwani.cabiassignment.repository

import android.util.Log
import com.ashwani.cabiassignment.model.Nations
import com.ashwani.cabiassignment.retrofit.RetrofitClient
import com.ashwani.cabiassignment.room.CabiRoomDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CabiRepository {

    fun getDBInstance(): CabiRoomDatabase {
        return CabiRoomDatabase.getDataBase()
    }

    fun getCabiNationData(){

        val retrofitRef = RetrofitClient.apiInterface.getNations("Nation", "Population")

        retrofitRef.enqueue(object: Callback<Nations>{

            override fun onResponse(call: Call<Nations>, response: Response<Nations>) {
                val data = response.body()
                data?.data?.let {
                    getDBInstance().getNationsDao().deleteAllData()
                    getDBInstance().getNationsDao().insert(it)
                }
            }

            override fun onFailure(call: Call<Nations>, t: Throwable) {
                Log.e("Error : ", t.message.toString())
            }
        })
    }
}