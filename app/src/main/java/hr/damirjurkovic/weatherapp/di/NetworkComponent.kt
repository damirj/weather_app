package hr.damirjurkovic.weatherapp.di

import dagger.Component
import hr.damirjurkovic.weatherapp.networking.WeatherViewModelFactory
import hr.damirjurkovic.weatherapp.ui.weather.view.fragments.WeatherFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun inject(weatherFragment: WeatherFragment) {}
    fun inject(weatherViewModelFactory: WeatherViewModelFactory)

}