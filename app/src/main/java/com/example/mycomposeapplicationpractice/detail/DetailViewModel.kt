package com.example.mycomposeapplicationpractice.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapplicationpractice.domain.repository.WeatherState
import com.example.mycomposeapplicationpractice.domain.use_cases.GetWeatherUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {
    private val _weathers: MutableLiveData<List<Weather>> = MutableLiveData<List<Weather>>()
    private val _test: MutableLiveData<Any> = MutableLiveData<Any>()


    val weather:LiveData<List<Weather>>
    get() = _weathers

    val test:LiveData<Any>
        get() = _test

    fun loadWeathers() {
        // TODO: asynchronous operation to get weathers
        Log.v("detailViewModel", "loadWeathers")
        viewModelScope.launch {
            Log.v("detailViewModel", "loadWeathers")
            getWeatherUseCase.invoke().collect {
                when(it) {
                    is WeatherState.Success -> {
//                        _state.value = LatestNewsUiState.Success("Success")
                        _test.value = it.data
                        Log.v("detailViewModel", "_test.value ${_test}")
                    }
                    is WeatherState.Error -> {
//                        _state.value = LatestNewsUiState.Error
                    }
                    else -> {
                        Log.v("detailViewModel", "error")
                    }
                }
            }
        }
        }

}

//sealed class LatestNewsUiState {
//    data class Success(val news: String): LatestNewsUiState()
//    object Error: LatestNewsUiState()
//}

data class Weather(val temperature: Int)