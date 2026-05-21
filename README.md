1. Visual — views + navegación con datos hardcodeados
  2. Data models — data classes del JSON y de la LazyRow
  3. Network — RetrofitHelper + ApiInterface
  4. Repository — abre el Response y regresa datos limpios
  5. ViewModel del API — llama al repository con viewModelScope + withContext(Dispatchers.IO)
  6. DataStore — Preferencias con Flow para leer y suspend fun para escribir
  7. Conectar en la View — LaunchedEffect, collectAsState, rememberCoroutineScope

  Y las corrutinas aparecen en tres lugares específicos:
  - ViewModel → viewModelScope.launch { withContext(Dispatchers.IO) { } }
  - View → rememberCoroutineScope para llamar funciones suspend del DataStore
  - Repository y ApiInterface → suspend fun porque son llamadas que toman tiempo
