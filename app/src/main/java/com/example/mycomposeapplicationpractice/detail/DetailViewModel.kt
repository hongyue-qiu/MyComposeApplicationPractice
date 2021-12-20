package com.example.mycomposeapplicationpractice.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.*


class DetailViewModel : ViewModel() {
    private val weathers: MutableLiveData<List<Weather>> by lazy {
        MutableLiveData<List<Weather>>().also {
            loadWeathers()
        }
    }

    fun getWeathers(): LiveData<List<Weather>> {
        return weathers;
    }

    private fun loadWeathers() {
        // TODO: asynchronous operation to get weathers
        val client = OkHttpClient();
        val request:Request = Request.Builder()
            .url("https://api.gugudata.com/weather/weatherinfo/demo")
            .build()
        val response = client.newCall(request).execute()
        Log.v("get1", "1111")
        Log.v("get", response.toString())

    }
}

data class Weather(val temperature: Int)