package hr.damirjurkovic.weatherapp.ui.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.damirjurkovic.weatherapp.networking.repository.NetworkRepository
import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(private val repository: NetworkRepository) : ViewModel() {

    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse: LiveData<WeatherResponse>
        get() = _weatherResponse

    fun getWeather(location: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getWeather(location)
            updateWeather(response)
        }
    }

    private suspend fun updateWeather(weatherResponse: WeatherResponse) {
        withContext(Dispatchers.Main) {
            _weatherResponse.value = weatherResponse
        }
    }
}