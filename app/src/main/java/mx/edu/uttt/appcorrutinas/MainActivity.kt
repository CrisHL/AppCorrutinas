package mx.edu.uttt.appcorrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.uttt.appcorrutinas.ui.theme.AppCorrutinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            AppCorrutinasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(viewModel)
                }
            }
        }
    }
}

@Composable
fun Content(viewModel: MainViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        BotonColor()
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }
        else{
            Text(text = viewModel.resultState)
        }
        /*
        Text(text = viewModel.resultState)
        
         */
        Button(onClick = { viewModel.fetchData() }) {
            Text(text = "Call API Simulation")
        }


    }
}

@Composable
fun BotonColor() {
    var color by remember {
        mutableStateOf(false)
    }
    Button(onClick = { color = !color }, colors = ButtonDefaults.buttonColors(
        containerColor = if (color) Color.Blue else Color.Red
    )){
        Text(text = "Cambiar Color")
    }
}