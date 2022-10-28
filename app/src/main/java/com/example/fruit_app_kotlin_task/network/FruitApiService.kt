package com.example.fruit_app_kotlin_task.network

import com.example.fruit_app_kotlin_task.response.FruitModel

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mercadosagricolaspr.com/farmer-dev/apis/"




private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface FruitApiService {

    @GET("product/searchproductbycatagory_6prod?limit=6")
     fun getFruitList():Call<FruitModel>

//     @GET("product/searchproductbycatagory_6prod?limit=6")
//     fun getFruitList():Call<String>

}

object FruitApi{
    val retrofitService: FruitApiService by lazy {
        retrofit.create(FruitApiService::class.java) }
}
