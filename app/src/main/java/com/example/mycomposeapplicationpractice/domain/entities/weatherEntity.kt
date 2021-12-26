package com.example.mycomposeapplicationpractice.domain.entities

import androidx.annotation.Keep

@Keep
data class WeatherEntity (
    val WeatherInfo:String,
    val WeatherTime:String,
    val Temperature:String,
    val WeatherWindLevel:String,
)