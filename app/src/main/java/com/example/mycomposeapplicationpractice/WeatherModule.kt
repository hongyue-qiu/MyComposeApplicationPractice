package com.example.mycomposeapplicationpractice

import com.example.mycomposeapplicationpractice.detail.DetailViewModel
import com.example.mycomposeapplicationpractice.domain.repository.WeatherDetailRepository
import com.example.mycomposeapplicationpractice.domain.use_cases.GetWeatherUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weathersModule = module {
    single<WeatherDetailRepository> { WeatherDetailRepository()}
    viewModel { DetailViewModel(get()) }
    factory { GetWeatherUseCase(get())}

}
