package com.example.exam

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
fun SelectCharacterScreen(navController: NavController) {
    var selectedImage by remember { mutableStateOf<Int?>(null) }

    val imageList = listOf(
        R.drawable.gomah,
        R.drawable.goku,
        R.drawable.masked_majin,
        R.drawable.piccolo,
        R.drawable.supreme,
        R.drawable.vegeta
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Main Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in 0 until 3) {
                    CharacterImage(
                        imageId = imageList[i],
                        isSelected = selectedImage == i,
                        onClick = { selectedImage = i }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in 3 until 6) {
                    CharacterImage(
                        imageId = imageList[i],
                        isSelected = selectedImage == i,
                        onClick = { selectedImage = i }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                navController.navigate("nameScreen")
            },
            enabled = selectedImage != null,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(200.dp).height(50.dp)
        ) {
            Text(
                text = "Continuar",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CharacterImage(imageId: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp)
            .clickable(onClick = onClick)
            .then(
                if (isSelected) Modifier.border(4.dp, Color.Blue, RoundedCornerShape(10.dp))
                else Modifier
            )
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Personajes",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectCharacterScreenPreview() {
    // Usamos un NavController ficticio para el Preview
    val navController = rememberNavController()
    SelectCharacterScreen(navController)
}