package com.example.fruit_app_kotlin_task.response

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("pid"           ) var pid           : String? = null,
    @SerializedName("cid"           ) var cid           : String? = null,
    @SerializedName("type"          ) var type          : String? = null,
    @SerializedName("image"         ) var image         : String? = null,
    @SerializedName("name"          ) var name          : String? = null,
    @SerializedName("description"   ) var description   : String? = null,
    @SerializedName("cost_price"    ) var costPrice     : String? = null,
    @SerializedName("sell_price"    ) var sellPrice     : String? = null,
    @SerializedName("unit"          ) var unit          : String? = null,
    @SerializedName("total_qty"     ) var totalQty      : String? = null,
    @SerializedName("approve"       ) var approve       : String? = null,
    @SerializedName("created_at"    ) var createdAt     : String? = null,
    @SerializedName("updated_at"    ) var updatedAt     : String? = null,
    @SerializedName("created_by"    ) var createdBy     : String? = null,
    @SerializedName("farmerName"    ) var farmerName    : String? = null,
    @SerializedName("farmerCompany" ) var farmerCompany : String? = null
)