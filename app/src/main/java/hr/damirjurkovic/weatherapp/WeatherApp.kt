package hr.damirjurkovic.weatherapp

import android.app.Application
import hr.damirjurkovic.weatherapp.common.BASE_URL
import hr.damirjurkovic.weatherapp.di.DaggerNetworkComponent
import hr.damirjurkovic.weatherapp.di.NetworkComponent
import hr.damirjurkovic.weatherapp.di.NetworkModule

class WeatherApp : Application() {

    companion object {
        lateinit var networkComponent: NetworkComponent
    }

    override fun onCreate() {
        super.onCreate()
        networkComponent = DaggerNetworkComponent.builder()
            .networkModule(NetworkModule(BASE_URL))
            .build()
    }
}