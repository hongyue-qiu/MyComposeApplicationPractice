package com.example.mycomposeapplicationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapplicationpractice.ui.theme.MyComposeApplicationPracticeTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(temperature: String) {
    fun onDetailClick() {
        // TODO go to anther page
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeApplicationPracticeTheme {
        Greeting("Android")
    }
}