package com.ashwani.cabiassignment.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashwani.cabiassignment.model.Nation

@Dao
interface CabiNationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<Nation>)

    @Query("DELETE FROM Nation")
    fun deleteAllData()

    @Query("SELECT * from Nation")
    fun getNations() : LiveData<List<Nation>>

}