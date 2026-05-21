package com.example.practica.practica3.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckPreferences(private val contexto: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore("chuck_prefs")
        val NOMBRE = stringPreferencesKey("nombre")
    }

    val nombre: Flow<String> = contexto.dataStore.data.map {
        it[NOMBRE] ?: "Chuck Norris"
    }

    suspend fun guardarNombre(nombre: String) {
        contexto.dataStore.edit {
            it[NOMBRE] = nombre
        }
    }
}