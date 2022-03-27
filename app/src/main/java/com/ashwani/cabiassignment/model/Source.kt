package com.ashwani.cabiassignment.model

import com.google.gson.annotations.SerializedName

data class Source (
    val measures: List<String>,
    val annotations: Annotations,
    val name: String,
    val substitutions: List<Any?>
)

data class Annotations (
    @SerializedName("source_name")
    val sourceName: String,

    @SerializedName("source_description")
    val sourceDescription: String,

    @SerializedName("dataset_name")
    val datasetName: String,

    @SerializedName("dataset_link")
    val datasetLink: String,

    @SerializedName("table_id")
    val tableID: String,

    val topic: String,
    val subtopic: String
)