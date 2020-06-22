package hr.damirjurkovic.weatherapp.networking.repository

import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse

interface NetworkRepository {

    suspend fun getWeather(location: String): WeatherResponse
}