package com.example.mycomposeapplicationpractice.domain.use_cases

import com.example.mycomposeapplicationpractice.domain.repository.WeatherDetailRepository
import com.example.mycomposeapplicationpractice.domain.repository.WeatherState
import kotlinx.coroutines.flow.Flow

class GetWeatherUseCase(private val weatherDetailRepository: WeatherDetailRepository) {
    suspend operator fun invoke(): Flow<WeatherState> {
        return weatherDetailRepository.getWeathers()
    }
}