package hr.damirjurkovic.weatherapp.ui.weather.view.activity

import hr.damirjurkovic.weatherapp.R
import hr.damirjurkovic.weatherapp.common.showFragment
import hr.damirjurkovic.weatherapp.ui.base.BaseActivity
import hr.damirjurkovic.weatherapp.ui.weather.view.fragments.WeatherFragment

class MainActivity : BaseActivity() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun setUpUi() {
        showFragment(R.id.fragmentContainer, WeatherFragment.newInstance())

    }

}