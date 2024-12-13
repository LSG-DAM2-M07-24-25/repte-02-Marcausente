package com.example.exam

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NameScreen() {
    Text(text = "Ahora pongo los nombres que estoy testing y todo eso")
}

@Preview(showBackground = true)
@Composable
fun NameScreenPreview() {
    NameScreen()
}