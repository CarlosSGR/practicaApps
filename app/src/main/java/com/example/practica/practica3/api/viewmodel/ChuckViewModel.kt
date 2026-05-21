package com.example.practica.practica3.api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica.practica3.api.data.models.ChuckJoke
import com.example.practica.practica3.api.repository.ChuckRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChuckViewModel: ViewModel() {
    private val repository = ChuckRepository()

    var joke by mutableStateOf<ChuckJoke?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun cargarJoke() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                isLoading = true
                joke = repository.getRandomJoke()
                isLoading = false
            }
        }
    }
}