package com.example.mycomposeapplicationpractice.domain.repository

import android.util.Log
import com.example.mycomposeapplicationpractice.domain.entities.WeatherEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class WeatherDetailRepository() {
    private val weatherCache = MutableStateFlow<List<WeatherEntity>>({} as List<WeatherEntity>)
    fun getWeathers(): Flow<WeatherState> = weatherCache.flatMapConcat {
        flow {
            emit(WeatherState.Loading)
            val client = OkHttpClient();
            val request: Request = Request.Builder()
                .url("https://api.gugudata.com/weather/weatherinfo/demo")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonObj = JSONObject(response.body?.string());
                val jsonData = jsonObj.get("Data")
                emit(WeatherState.Success(jsonData as List<WeatherEntity>))
            }else {
                Log.v("detailViewModel", "error: !!!!")
                emit(WeatherState.Error("request failed"))
            }
        }
    }
}

sealed class WeatherState {
    object Loading: WeatherState()
    data class Success(val data:List<WeatherEntity>): WeatherState()
    data class Error(val error: String): WeatherState()
}