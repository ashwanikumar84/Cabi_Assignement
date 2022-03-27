package com.ashwani.cabiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Nation(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
                  @SerializedName("ID Nation")
                  var ID_Nation: String,
                  @SerializedName("ID Year")
                  var ID_Year: String,
                  @SerializedName("Nation")
                  var Nation: String,
                  @SerializedName("Population")
                  var Population: String,
                  @SerializedName("Slug Nation")
                  var Slug_Nation: String,
                  @SerializedName("Year")
                  var Year: String)