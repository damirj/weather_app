package hr.damirjurkovic.weatherapp.networking

import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse

class WeatherInteractorImpl(private val apiService: WeatherApiService) : WeatherInteractor {

    override suspend fun getWeather(location: String): WeatherResponse {
        return apiService.getWeather(location)
    }
}