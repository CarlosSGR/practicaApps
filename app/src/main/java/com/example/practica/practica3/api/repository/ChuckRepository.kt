package com.example.practica.practica3.api.repository

import com.example.practica.practica3.api.data.models.ChuckJoke
import com.example.practica.practica3.api.data.network.RetrofitHelper

class ChuckRepository {
    private val service = RetrofitHelper.getRetrofitService()

    suspend fun getRandomJoke(): ChuckJoke? {
        val response = service.getRandomJoke()

        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}