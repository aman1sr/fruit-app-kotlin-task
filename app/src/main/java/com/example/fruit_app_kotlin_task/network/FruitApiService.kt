package com.example.fruit_app_kotlin_task.network

import com.example.fruit_app_kotlin_task.response.FruitModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mercadosagricolaspr.com/farmer-dev/apis/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface FruitApiService {
    @GET("product/searchproductbycatagory_6prod?limit=6")
    suspend fun getFruitList():List<FruitModel>

}

object FruitApi{
    val retrofitService: FruitApiService by lazy { retrofit.create(FruitApiService::class.java) }
}
