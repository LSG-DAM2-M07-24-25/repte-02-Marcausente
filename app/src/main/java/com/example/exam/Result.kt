package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
fun ResultScreen(navController: NavController, characterName: String, selectedImage: Int?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Image Above",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (selectedImage != null) {
            Image(
                painter = painterResource(id = selectedImage),
                contentDescription = "Selected Character Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            Text( //Esto te lo he puesto por el control de errores, si no detecta la imagen que es lo que me pasaba te aparece esto
                text = "Imagen no disponible",
                fontSize = 18.sp,
                color = Color.Red,
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = characterName,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(200.dp).height(50.dp)
        ) {
            Text(
                text = "Volver",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}