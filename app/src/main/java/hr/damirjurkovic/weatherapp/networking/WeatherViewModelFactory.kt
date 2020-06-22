package hr.damirjurkovic.weatherapp.networking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.damirjurkovic.weatherapp.WeatherApp
import hr.damirjurkovic.weatherapp.networking.repository.NetworkRepository
import hr.damirjurkovic.weatherapp.ui.weather.presentation.WeatherViewModel
import javax.inject.Inject

class WeatherViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var repository: NetworkRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        WeatherApp.networkComponent.inject(this)
        return WeatherViewModel(repository) as T
    }
}