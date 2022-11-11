package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.API

import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.data.FragranceResponse
import retrofit2.http.GET
import retrofit2.Call

/**
 * First API version. Discarded for ModelView use.
 */
interface FragranceAPI {

    @GET("11")
    fun getProductOne(): Call<FragranceResponse>

    @GET("12")
    fun getProductTwo(): Call<FragranceResponse>

    @GET("13")
    fun getProductThree(): Call<FragranceResponse>

    @GET("14")
    fun getProductFour(): Call<FragranceResponse>

    @GET("15")
    fun getProductFive(): Call<FragranceResponse>
}