package com.example.fruit_app_kotlin_task.response

data class Data (
val cid : String,
val category: String,
val cdesc: String,
val c_img : String,
val cdata : List<CategoryFruitList>
)