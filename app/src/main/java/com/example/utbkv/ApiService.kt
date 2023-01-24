package com.example.utbkv

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("premet")
    fun getDataFromDatabase(): Call<List<Data>>
}