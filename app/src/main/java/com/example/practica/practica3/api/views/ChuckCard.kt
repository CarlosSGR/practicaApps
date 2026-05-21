package com.example.practica.practica3.api.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica.practica3.api.data.models.ChuckMovie


@Composable
fun ChuckCard(imagen: Int, nombre: String){
    Card() {
        Column() {
            Image(painter = painterResource(id =imagen),
                contentDescription = "Pelicula",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.width(120.dp).height(150.dp)
            )
            Text(text = nombre,
                minLines = 3,
                modifier = Modifier.width(120.dp)
                )
        }
    }
}