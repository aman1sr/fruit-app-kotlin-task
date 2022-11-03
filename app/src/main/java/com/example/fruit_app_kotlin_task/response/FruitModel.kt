package com.example.fruit_app_kotlin_task.response

import com.google.gson.annotations.SerializedName

data class FruitModel(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("total_rec") var totalRec: Int? = null,
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf()
)