package com.example.mycomposeapplicationpractice.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import org.json.JSONObject


class DetailViewModel : ViewModel() {
    private val _weathers: MutableLiveData<List<Weather>> = MutableLiveData<List<Weather>>()
    private val _test: MutableLiveData<Any> = MutableLiveData<Any>()

    val weather:LiveData<List<Weather>>
    get() = _weathers

    val test:LiveData<Any>
        get() = _test

    fun getWeathers() {
        viewModelScope.launch {
            val temp = loadWeathers()
            _test.value = temp!!
            Log.v("detailViewModel", "test: $temp")
        }
    }

    private suspend fun loadWeathers():Any? {
        // TODO: asynchronous operation to get weathers

        return withContext(Dispatchers.IO){
            val client = OkHttpClient();
            val request:Request = Request.Builder()
                .url("https://api.gugudata.com/weather/weatherinfo/demo")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonObj = JSONObject(response.body?.string());
                val jsonData = jsonObj.get("Data")
                return@withContext jsonData;
            }else {
                Log.v("detailViewModel", "error: !!!!")
                return@withContext ""
            }

        }
    }
}

data class Weather(val temperature: Int)