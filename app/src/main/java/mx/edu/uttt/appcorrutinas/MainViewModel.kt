package mx.edu.uttt.appcorrutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        //creamos la corrutina del viewmodel

        viewModelScope.launch {
            try {
                isLoading = true
                LoadApi()
            }
            catch (e: Exception){
                println("Error: ${e.message}")
            }
            finally {
                isLoading = false
            }
        }

        /*
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Respuesta de la API"
        }
        resultState = result
        */

    }

    private suspend fun LoadApi(){
        var resultado = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la API"
        }
        resultState = resultado;
    }

    fun bloqueoAppSimulado(){
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
}