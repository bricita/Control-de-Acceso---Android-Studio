package com.example.practica_semana09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica_semana09.ui.theme.Practica_Semana09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_Semana09Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ControlAcceso()
                }

            }
        }
    }
}

//Composable = Para diseñar pantallas
@Composable
fun ControlAcceso(){
    var entradaTexto by remember { mutableStateOf("") }
    var perDentro by remember { mutableStateOf(0) }
    var ultimoIngreso by remember { mutableStateOf("") }

    Column() {
        Text("------CONTROL AFORO------")
        Text("Personas dentro: $perDentro")
        Text("Ultimo ingreso: $ultimoIngreso")

        TextField(
            value = entradaTexto,
            onValueChange = {entradaTexto = it}
        )

        Button(
            onClick = {
                ultimoIngreso = entradaTexto
                perDentro = perDentro + 1
                entradaTexto = ""
            }) {
            Text("Registrar e Ingresar")
        }

        Row() {
            Button(
                onClick = {
                    if(perDentro > 0){
                        perDentro = perDentro - 1
                    }else{
                        perDentro = 0
                    }
                }
            ) {
                Text("Salida (-1)")
            }
            if (perDentro == 0){
                Text("RESTRICCION: Nos se puede disminuir el numero de personas")
            }
            Button(
                onClick ={
                    perDentro = 0
                    ultimoIngreso = "Ninguno"
                }
            ) {
                Text("Reiniciar")
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica_Semana09Theme {
        Greeting("Android")
    }
}