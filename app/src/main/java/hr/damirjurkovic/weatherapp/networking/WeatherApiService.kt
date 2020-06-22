package hr.damirjurkovic.weatherapp.networking

import hr.damirjurkovic.weatherapp.common.API_KEY
import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String = API_KEY
    ): WeatherResponse
}