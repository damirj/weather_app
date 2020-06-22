package hr.damirjurkovic.weatherapp.networking.repository

import hr.damirjurkovic.weatherapp.networking.WeatherInteractor
import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse

class NetworkRepositoryImpl(private val interactor: WeatherInteractor) : NetworkRepository {

    override suspend fun getWeather(location: String): WeatherResponse {
        return interactor.getWeather(location)
    }
}