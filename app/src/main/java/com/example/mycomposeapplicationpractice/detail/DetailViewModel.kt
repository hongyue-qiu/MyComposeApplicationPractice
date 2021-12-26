package com.example.mycomposeapplicationpractice.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapplicationpractice.domain.repository.WeatherState
import com.example.mycomposeapplicationpractice.domain.use_cases.GetWeatherUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {
    private val _weathers: MutableLiveData<List<Weather>> = MutableLiveData<List<Weather>>()
    private val _test: MutableLiveData<Any> = MutableLiveData<Any>()


    val weather:LiveData<List<Weather>>
    get() = _weathers

    val test:LiveData<Any>
        get() = _test

    fun getWeathers() {
        viewModelScope.launch {
            loadWeathers()
//            _test.value = temp!!
            Log.v("detailViewModel", "test: ")
        }
    }

    private suspend fun loadWeathers(): Function<Job> = {
        // TODO: asynchronous operation to get weathers
        viewModelScope.launch {
            getWeatherUseCase.invoke().collect { data ->
                when(data) {
                    is WeatherState.Success -> {
//                        _state.value = LatestNewsUiState.Success("Success")
                        _test.value = data
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
//        return withContext(Dispatchers.IO){
//            val client = OkHttpClient();
//            val request:Request = Request.Builder()
//                .url("https://api.gugudata.com/weather/weatherinfo/demo")
//                .build()
//
//            val response = client.newCall(request).execute()
//            if (response.isSuccessful) {
//                val jsonObj = JSONObject(response.body?.string());
//                val jsonData = jsonObj.get("Data")
//                return@withContext jsonData;
//            }else {
//                Log.v("detailViewModel", "error: !!!!")
//                return@withContext ""
//            }
//
//        }
        }

}

//sealed class LatestNewsUiState {
//    data class Success(val news: String): LatestNewsUiState()
//    object Error: LatestNewsUiState()
//}

data class Weather(val temperature: Int)