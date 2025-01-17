package com.erick.polimuseovr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erick.polimuseovr.ui.theme.PoliMuseoVRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliMuseoVRTheme {
                SplashScreen {
                    // Lógica para continuar a la pantalla principal después de presionar "Continuar"
                    setContent {
                        PoliMuseoVRTheme {
                            HomeScreen() // Pantalla principal después de "Continuar"
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onContinue: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.owl_image),
                contentDescription = "Imagen del búho",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "¡Bienvenido a PoliMuseoVR!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Explora la historia y el arte de una manera única.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onContinue) {
                Text(text = "Continuar")
            }
        }
    }
}

@Composable
fun HomeScreen(spacing: Dp = 10.dp, buttonSize: Dp = 200.dp, buttonTextSize: TextUnit = 20.sp) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF1EC175) // Fondo verde neón
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Encabezado
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /* Acción del botón de retroceso */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back), // Recurso personalizado
                        contentDescription = "Retroceder",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "¿Qué soy?",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            // Contenedor ajustable con ícono de cámara y botón
            Box(
                modifier = Modifier
                    .width(500.dp) // Ajustable: Cambia el ancho del Box
                    .height(700.dp) // Ajustable: Cambia la altura del Box
                    .background(Color(0xFFD0EFE7), RoundedCornerShape(16.dp)) // Fondo verde claro ajustable
                    .padding(16.dp),
                contentAlignment = Alignment.Center // Centra el contenido dentro del Box
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Soy el pulmón de la Tierra, con hojas de verde color, ayudo a purificar el aire, y en el bosque soy protector.",
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF1EC175) // Color de texto verde más oscuro
                    )
                    Spacer(modifier = Modifier.height(spacing)) // Aquí se ajusta el espacio entre el texto y la imagen
                    Image(
                        painter = painterResource(id = R.drawable.ic_camera), // Recurso de cámara
                        contentDescription = "Cámara",
                        modifier = Modifier.size(150.dp) // Ajustable: Tamaño del icono de la cámara
                    )
                    Spacer(modifier = Modifier.height(20.dp)) // Espacio entre la imagen y el botón
                    Button(
                        onClick = { /* Acción del botón */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1EC175)), // Color morado ajustable
                        modifier = Modifier
                            .width(buttonSize) // Ajusta el tamaño del botón
                            .height(60.dp) // Puedes ajustar la altura del botón también
                    ) {
                        Text(
                            text = "Encontrar",
                            color = Color.White,
                            fontSize = buttonTextSize // Tamaño ajustable para el texto
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(spacing = 16.dp, buttonSize = 250.dp, buttonTextSize = 24.sp) // Puedes ajustar el tamaño del texto aquí
}
