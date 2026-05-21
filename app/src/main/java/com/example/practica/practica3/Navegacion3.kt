package com.example.practica.practica3

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica.practica3.api.viewmodel.ChuckViewModel
import com.example.practica.practica3.api.viewmodel.MoviesVM
import com.example.practica.practica3.api.views.SegundaPantalla
import kotlinx.serialization.Serializable

@Serializable object Principal
@Serializable object Segunda

@Composable
fun Navegador(){
    val navController = rememberNavController()
    val Movies: MoviesVM = viewModel()
    val chuckVM: ChuckViewModel = viewModel()


    NavHost(navController = navController, startDestination = Principal){
        composable<Principal>{
            PantallaPrincipal(navController)
        }

        composable<Segunda>{
            SegundaPantalla(navController, Movies, chuckVM)
        }
    }
}