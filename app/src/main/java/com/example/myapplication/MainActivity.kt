package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploImagen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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
@Composable
fun EjemploTexto(modifier: Modifier = Modifier){
    Text(
        text = stringResource(R.string.segundo_dam),
        color = MaterialTheme.colorScheme.primary,
        fontSize = 50.sp,
        fontStyle = FontStyle.Italic,
        modifier = modifier
    )


}

@Composable
fun EjemploTextFieldRelleno(modifier: Modifier = Modifier){
    var texto by remember { mutableStateOf("Texto")}

    TextField(
        value = texto,
        onValueChange = { texto = it},
        label = {Text(stringResource(R.string.etiqueta))},
        modifier = modifier
    )
}

@Composable
fun EjemploImagen(modifier: Modifier = Modifier){
    val imagen = painterResource(id = R.drawable.androidblack)

    Image(
        painter = imagen,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.5F,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        EjemploTexto()
    }
}