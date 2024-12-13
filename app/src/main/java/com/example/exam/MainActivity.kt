package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exam.ui.theme.ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "launch",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable("launch") {
                        LaunchScreen(
                            onEnterClick = { navController.navigate("SelectCharacter") },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                    composable("SelectCharacter") {
                        SelectCharacterScreen(navController)
                    }
                    composable("nameScreen/{selectedImage}") { backStackEntry ->
                        val selectedImage = backStackEntry.arguments?.getString("selectedImage")?.toIntOrNull()
                        NameScreen(navController, selectedImage)
                    }
                    composable("Result/{characterName}/{selectedImage}") { backStackEntry ->
                        val characterName = backStackEntry.arguments?.getString("characterName") ?: "Nombre del personaje"
                        val selectedImage = backStackEntry.arguments?.getString("selectedImage")?.toIntOrNull()
                        ResultScreen(navController, characterName, selectedImage)
                    }
                }

                    }
                }
            }
        }
    }


@Composable
fun LaunchScreen(modifier: Modifier, onEnterClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.dragonball_daima_logo),
                contentDescription = "Logo de db",
                modifier = Modifier
                    .size(400.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onEnterClick,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FullPagePreview() {
    ExamTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LaunchScreen(
                modifier = Modifier.padding(innerPadding),
                onEnterClick = {
                }
            )
        }
    }
}