package com.example.mycomposeapplicationpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mycomposeapplicationpractice.ui.theme.MyComposeApplicationPracticeTheme


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO request weather data
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Home(temperature = "12",this )
            }
        }
    }
}

@Composable
fun Home(temperature: String, homeFragment: ComposeView) {

    fun onDetailClick() {
        homeFragment.findNavController().navigate(R.id.detailFragment)
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Text(
            text = "Today $temperature!",
            modifier = Modifier
                .padding(0.dp, 100.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
                .height(200.dp),
            textAlign = TextAlign.Center
        )
        Button(onClick = { onDetailClick() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "go to detail page")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeDefault() {
    MyComposeApplicationPracticeTheme {
//        Home("15 C°", this)
    }
}