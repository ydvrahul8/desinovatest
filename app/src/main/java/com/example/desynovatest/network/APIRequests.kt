package com.example.desynovatest.network

import com.example.desynovatest.model.GraphModel
import retrofit2.http.GET

interface APIRequests {

    @GET("v1/511c6beb")
    suspend fun getData():GraphModel

}