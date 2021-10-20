package com.example.retrofitsingetondemo.data.network.endpoint

import com.example.retrofitsingetondemo.data.model.HearthStoneResponse
import com.example.retrofitsingetondemo.util.secret.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface HearthStoneApiEndPoints {
    @GET("/cards/classes/{classType}")
    suspend fun getClasses(
        @Header("x-rapidapi-host") host: String = "omgvamp-hearthstone-v1.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = API_KEY,
        @Path("classType") classType: String
    ): Response<HearthStoneResponse>

    @GET("/cards/{cardName}")
    suspend fun getCardByName(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Path("cardName") classType: String
    ): Response<HearthStoneResponse>

    @GET("/info")
    suspend fun getInfo(
        @Header("x-rapidapi-host") host: String = "omgvamp-hearthstone-v1.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = API_KEY,
    ): Response<HearthStoneResponse>
}
