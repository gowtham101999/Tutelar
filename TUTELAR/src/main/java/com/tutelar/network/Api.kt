package com.tutelar.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

/**
 * Created at: Aug 2022
 * Created by: Gowtham R
 */
internal interface Api {

    @GET("no-auth/api-key/validate")
    suspend fun isValidApiKey(@Header("api-key") apiKey: String): Response<com.tutelar.model.Response>

}