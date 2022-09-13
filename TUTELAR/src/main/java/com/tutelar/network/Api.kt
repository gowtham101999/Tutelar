package com.tutelar.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created at: Aug 2022
 * Created by: Gowtham R
 */
internal interface Api {

    @GET("api-key/validate/{api_key}")
    suspend fun isValidApiKey(@Path("api_key") apiKey: String): Response<com.tutelar.model.Response>

}