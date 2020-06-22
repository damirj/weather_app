package hr.damirjurkovic.weatherapp.ui.weather.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.damirjurkovic.weatherapp.R
import hr.damirjurkovic.weatherapp.WeatherApp
import hr.damirjurkovic.weatherapp.common.convertToCelsius
import hr.damirjurkovic.weatherapp.common.subscribe
import hr.damirjurkovic.weatherapp.networking.response.WeatherResponse
import hr.damirjurkovic.weatherapp.ui.base.BaseFragment
import hr.damirjurkovic.weatherapp.ui.weather.presentation.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_weather.*
import javax.inject.Inject

class WeatherFragment : BaseFragment() {

    @Inject
    lateinit var weatherViewModelFactory: ViewModelProvider.Factory
    private lateinit var weatherViewModel: WeatherViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_weather

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WeatherApp.networkComponent.inject(this)
        initViewModel()
        subscribeToData()
        initListeners()
    }

    private fun initViewModel() {
        weatherViewModel =
            ViewModelProvider(this, weatherViewModelFactory).get(WeatherViewModel::class.java)
    }

    private fun initListeners() {
        getWeather.setOnClickListener { weatherViewModel.getWeather(inputPlace.text.toString()) }
    }

    private fun subscribeToData() {
        weatherViewModel.weatherResponse.subscribe(this, this::handleWeatherChange)
    }

    private fun handleWeatherChange(weatherResponse: WeatherResponse) {
        weatherResponse.main?.temp?.let {
            temperature.text = convertToCelsius(it).toString() + "°C"
        }
        humidity.text = weatherResponse.main?.humidity.toString() + "%"
        wind.text = weatherResponse.wind?.speed.toString() + "m/s"
    }

    companion object {
        fun newInstance(): Fragment {
            return WeatherFragment()
        }
    }
}