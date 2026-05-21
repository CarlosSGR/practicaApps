package com.example.practica.practica3.api.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.practica.practica3.api.data.models.ChuckMovie
import com.example.practica.practica3.api.viewmodel.ChuckViewModel
import com.example.practica.practica3.api.viewmodel.MoviesVM
import com.example.practica.practica3.datastore.ChuckPreferences
import kotlinx.coroutines.launch


@Composable
fun SegundaPantalla(navController: NavController, Movies: MoviesVM, chuckVM: ChuckViewModel){

    var nombre by remember { mutableStateOf("") }

    val context = LocalContext.current
    val prefs = ChuckPreferences(context)
    val corrutina = rememberCoroutineScope()
    val nombreGuardado by prefs.nombre.collectAsState(initial = "Chuck Norris")

    LaunchedEffect(Unit) {
        chuckVM.cargarJoke()
    }


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(15.dp)) {
        Text("Series y Películas famosas", modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(Movies.ChuckMovie){
                ChuckCard(it.imagen, it.nombre)
            }
        }
        Spacer(Modifier.height(8.dp))
        TextField(value = nombre, onValueChange = {nombre = it})
        Text("Hecho por el mismísimo ${nombreGuardado}.")//Aqui vamos a cambiar por el datastore
        AsyncImage(model = chuckVM.joke?.icon_url,
            contentDescription = "Icono Chuck")
        Text(text = chuckVM.joke?.value?: "Cargando chiste...")
        Spacer(Modifier.weight(1f))
        Text(text = chuckVM.joke?.id?: "Cargando id...")
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
            }

            IconButton(onClick = {
                corrutina.launch { prefs.guardarNombre(nombre) }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")

            }

            IconButton(onClick = {
                chuckVM.cargarJoke()
            }) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "Recargar")
            }
        }

    }

}