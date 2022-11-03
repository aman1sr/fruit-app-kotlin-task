package com.example.fruit_app_kotlin_task.network

import com.example.fruit_app_kotlin_task.response.FruitModel

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
* Retrofit creates a network API for the app based on the content from the web service.
* It fetches data from the web service and routes it through a separate converter library
* that knows how to decode the data and return it in the form of useful objects
* */

/*
* FruitApiService class holds the network layer for the app,
*            ViewModel will use this API to communicate with the web service
* */
private const val BASE_URL = "https://mercadosagricolaspr.com/farmer-dev/apis/"

/*
* Retrofit needs 2 things to build a web services API:
*   1) base URI
*   2) converter factory ( tells Retrofit what to do with the data it gets back from the web service )
*
*
* */

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// an interface that defines how Retrofit talks to the web server using HTTP requests
interface FruitApiService {

    @GET("product/searchproductbycatagory_6prod?limit=6")
    suspend fun getFruitList():FruitModel
}

/*
*  the app only needs one Retrofit service instance,
* you expose the service to the rest of the app using a public object called [FruitApi]
* */
object FruitApi{
    val retrofitService: FruitApiService by lazy { // you lazily initialize the Retrofit service, Because this call is computationally expensive,
        retrofit.create(FruitApiService::class.java)   // create() method creates the Retrofit service itself with the MarsApiService interface.
    }
}
/*
*  so, each time our ViewModel calls MarsApi.retrofitService,
*  it will get a singleton Retrofit object that implements FruitApiService
* */
