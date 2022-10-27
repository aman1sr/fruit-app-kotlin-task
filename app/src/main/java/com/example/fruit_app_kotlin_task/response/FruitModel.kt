package com.example.fruit_app_kotlin_task.response

data class FruitModel(
    val status: Boolean,
    val message: String,
    val total_rec: Int,
    val data: List<Data>
)