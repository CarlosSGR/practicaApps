package com.example.practica.practica3.api.data.network

import com.example.practica.practica3.api.data.models.ChuckJoke
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("random")
    suspend fun getRandomJoke(): Response<ChuckJoke>
}