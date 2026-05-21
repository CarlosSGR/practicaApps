package com.example.practica.practica3.api.viewmodel

import androidx.lifecycle.ViewModel
import com.example.practica.R
import com.example.practica.practica3.api.data.models.ChuckMovie

class MoviesVM: ViewModel() {
    var ChuckMovie: List<ChuckMovie> = emptyList()
        private set

    init {
        val lista = mutableListOf<ChuckMovie>()
        lista.add(ChuckMovie(R.drawable.cover, "McQuade, el lobo solitario"))
        lista.add(ChuckMovie(R.drawable.cover, "Prisioneros de Guerra"))
        lista.add(ChuckMovie(R.drawable.cover, "Walker, Texas Ranger"))
        lista.add(ChuckMovie(R.drawable.cover, "Logan's War: Bound by Honor"))

        ChuckMovie = lista
    }
}