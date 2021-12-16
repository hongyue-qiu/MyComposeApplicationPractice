package com.example.mycomposeapplicationpractice.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun DetailRow(temperature: String) {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Spacer(modifier = Modifier
            .size(60.dp)
            .height(60.dp)
            .width(60.dp)
            .background(color = Color.Yellow))
        Column(
            Modifier
                .width(200.dp)
                .padding(16.dp, 0.dp)
        ) {
            Text(
                text = "Today $temperature",
                modifier = Modifier
                    .background(Color.LightGray)
                    .width(100.dp)
                    .height(35.dp),
                textAlign = TextAlign.Center,
            )
            Row(
                modifier = Modifier
                    .width(260.dp)
                    .height(25.dp)
                    .padding(0.dp, 5.dp, 0.dp, 0.dp),
            ) {
                Text(text = "weather detail", fontSize = TextUnit.Unspecified)
            }
        }
    }

}