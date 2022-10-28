package com.example.fruit_app_kotlin_task.response

import com.google.gson.annotations.SerializedName

data class FruitModel(

    @SerializedName("cid"      ) var cid      : String?          = null,
    @SerializedName("category" ) var category : String?          = null,
    @SerializedName("cdesc"    ) var cdesc    : String?          = null,
    @SerializedName("c_img"    ) var cImg     : String?          = null,
    @SerializedName("cdata"    ) var cdata    : ArrayList<Data> = arrayListOf()

)