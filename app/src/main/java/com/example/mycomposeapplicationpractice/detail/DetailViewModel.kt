package com.example.mycomposeapplicationpractice.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    }
}

data class Weather(val temperature: Int)