package com.example.mycomposeapplicationpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(temperature: String,navController: NavController) {

    fun onDetailClick() {
        navController.navigate("detail")
    }
    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = "Today $temperature!",
            modifier = Modifier.padding(0.dp,100.dp).background(Color.LightGray).fillMaxWidth().height(200.dp),
            textAlign = TextAlign.Center
        )
        Button(onClick = { onDetailClick() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "go to detail page")
        }
    }

}