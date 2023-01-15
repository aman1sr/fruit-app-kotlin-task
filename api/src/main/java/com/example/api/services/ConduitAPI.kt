package com.example.api.services

import io.realworld.api.models.responses.ArticlesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
     fun getArticles() : Call<ArticlesResponse>

}