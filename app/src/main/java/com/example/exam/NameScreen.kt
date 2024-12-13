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
    var characterName by remember { mutableStateOf("") }

    val imageToSend = selectedImage ?: R.drawable.goku //He puesto que si no hay imagen seleccionada se ponga por defecto la de goku para eviar problemas

    val isButtonEnabled = characterName.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Logo de db",
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(90.dp))

        OutlinedTextField(
            value = characterName,
            onValueChange = { characterName = it },
            placeholder = { Text("Nombre del personaje") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(300.dp))

        Button(
            onClick = {
                if (isButtonEnabled) {
                    navController.navigate("Result/$characterName/$imageToSend")
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(200.dp).height(50.dp),
            enabled = isButtonEnabled //basicamente esto esta porque si no has puesto nada en el campio de nombre no deja enviar y el boton se pone gris
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
    NameScreen(navController, selectedImage = R.drawable.goku)
}