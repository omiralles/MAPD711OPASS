package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.API

import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.data.FragranceResponse
import retrofit2.http.GET

/**
 * API interface to call the different endpoints from service.
 */
interface FragranceRetrofitAPI {
    @GET("11")
    suspend fun getProductOne(): FragranceResponse

    @GET("12")
    suspend fun getProductTwo(): FragranceResponse

    @GET("13")
    suspend fun getProductThree(): FragranceResponse

    @GET("14")
    suspend fun getProductFour(): FragranceResponse

    @GET("15")
    suspend fun getProductFive(): FragranceResponse
}