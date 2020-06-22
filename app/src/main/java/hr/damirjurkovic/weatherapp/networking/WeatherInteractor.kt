package hr.damirjurkovic.weatherapp.networking

import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse

interface WeatherInteractor {
    suspend fun getWeather(location: String): WeatherResponse
}