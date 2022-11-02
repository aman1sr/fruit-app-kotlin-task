package com.example.fruit_app_kotlin_task.network

import com.example.fruit_app_kotlin_task.response.FruitModel

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mercadosagricolaspr.com/farmer-dev/apis/"

//
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface FruitApiService {
    @GET("product/searchproductbycatagory_6prod?limit=6")
    suspend fun getFruitList():FruitModel
}

object FruitApi{
    val retrofitService: FruitApiService by lazy { retrofit.create(FruitApiService::class.java) }
}
