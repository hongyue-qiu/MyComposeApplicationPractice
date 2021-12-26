package com.example.mycomposeapplicationpractice.domain.repository

import android.util.Log
import com.example.mycomposeapplicationpractice.domain.entities.WeatherEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class WeatherDetailRepository() {
    private val weatherCache = MutableStateFlow({})
    @FlowPreview
    suspend fun getWeathers(): Flow<WeatherState> = weatherCache.flatMapConcat {
        flow {
            emit(WeatherState.Loading)
            val response = loadData();
            if (response === "request failed") {
                emit(WeatherState.Error("request failed"))
            }else {
                emit(WeatherState.Success(response))
            }
        }
    }

    private suspend fun loadData(): Any {
        return withContext(Dispatchers.IO){
            val client = OkHttpClient();
            val request: Request = Request.Builder()
                .url("https://api.gugudata.com/weather/weatherinfo/demo")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonObj = JSONObject(response.body?.string());
                val jsonData = jsonObj.get("Data")
                Log.v("detailViewModel", "success: !!!!")
                return@withContext jsonData
            }else {
                Log.v("detailViewModel", "error: !!!!")
                return@withContext "request failed"
            }
        }
    }
}

sealed class WeatherState {
    object Loading: WeatherState()
    data class Success(val data:Any): WeatherState()
    data class Error(val error: String): WeatherState()
}