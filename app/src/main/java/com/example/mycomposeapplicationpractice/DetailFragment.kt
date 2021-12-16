package com.example.mycomposeapplicationpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.mycomposeapplicationpractice.component.DetailRow
import com.example.mycomposeapplicationpractice.ui.theme.MyComposeApplicationPracticeTheme

class DetailFragment : Fragment() {
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
                DetailRow(temperature = "12")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailDefault() {
    MyComposeApplicationPracticeTheme {
        DetailRow("15 C°")
    }
}