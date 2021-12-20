package com.example.mycomposeapplicationpractice.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mycomposeapplicationpractice.component.DetailRow
import com.example.mycomposeapplicationpractice.ui.theme.MyComposeApplicationPracticeTheme

class DetailFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO request weather data
        val model:DetailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        model.getWeathers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply { 
            setContent {
                MyComposeApplicationPracticeTheme {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 32.dp, 0.dp, 0.dp)
                    ) {
                        Text(text = "temperature is ***", modifier = Modifier.padding(0.dp,12.dp))
                        LazyColumn {
                            items(3){index ->
                                DetailRow(temperature = "12-> $index")
                            }
                        }
                    }

                }
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