package com.example.exam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NameScreen(navController: NavController, selectedImage: Int?) {
    var characterName by remember { mutableStateOf("Nombre del personaje") }

    // Si no se seleccionó una imagen, puedes asignar una predeterminada, por ejemplo, R.drawable.goku
    val imageToSend = selectedImage ?: R.drawable.goku

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Image of Character",
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(90.dp))

        OutlinedTextField(
            value = characterName,
            onValueChange = { characterName = it },
            label = { Text("Nombre del personaje") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(300.dp))

        Button(
            onClick = {
                // Pasar el nombre y la imagen seleccionada a la pantalla de Result
                navController.navigate("Result/$characterName/$imageToSend")
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(200.dp).height(50.dp)
        ) {
            Text(
                text = "Mostrar",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameScreenPreview() {
    val navController = rememberNavController()
    // Asumimos que una imagen se pasa aquí como predeterminada.
    NameScreen(navController, selectedImage = R.drawable.goku)
}