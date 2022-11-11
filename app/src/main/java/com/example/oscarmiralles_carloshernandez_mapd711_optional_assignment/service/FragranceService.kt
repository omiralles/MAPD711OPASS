package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.service

import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.API.FragranceRetrofitAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Object to manage the connection service with retrofit
 */
object FragranceService {
    var baseURL = "https://dummyjson.com/products/"

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //API instance
    val retrofit = retrofitBuilder.create(FragranceRetrofitAPI::class.java)
}