package hr.damirjurkovic.weatherapp.networking.response

data class WeatherResponse(val weather: List<Weather>?, val main: MainInfo?, val wind: WindInfo?)

data class Weather(
    val id: Int? = 0,
    val main: String? = "",
    val description: String? = "",
    val icon: String? = ""
)

data class MainInfo(
    val temp: Double? = 0.0,
    val pressure: Double? = 0.0,
    val humidity: Int? = 0
)

data class WindInfo(val speed: Double? = 0.0, val deg: Int?)