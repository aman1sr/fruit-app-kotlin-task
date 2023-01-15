package com.example.api

import org.junit.Test
import org.junit.Assert.assertNotNull

class ConduitClientTests {

    private val conduitClient = ConduitClient()
    @Test
    fun `GET articles`(){
        val articles = conduitClient.api.getArticles().execute()
       assertNotNull(articles.body()?.articles)
    }

}