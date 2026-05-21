package com.example.practica.practica3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practica.R
import com.example.practica.practica3.api.views.SegundaPantalla

@Composable
fun PantallaPrincipal(navController: NavController){
    Image(painter = painterResource(id=R.drawable.cover),
        contentDescription = "fondo",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.fillMaxSize())
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Chuck Norris App", fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Text("La app de chistes de Chuck Norris", fontSize = 24.sp, fontStyle = FontStyle.Italic)
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(Segunda)
        }) {
            Text("Entrar")
        }
    }
}