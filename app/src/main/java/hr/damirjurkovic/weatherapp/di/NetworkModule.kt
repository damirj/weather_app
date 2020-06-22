package hr.damirjurkovic.weatherapp.di

import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hr.damirjurkovic.weatherapp.networking.WeatherApiService
import hr.damirjurkovic.weatherapp.networking.WeatherInteractor
import hr.damirjurkovic.weatherapp.networking.WeatherInteractorImpl
import hr.damirjurkovic.weatherapp.networking.WeatherViewModelFactory
import hr.damirjurkovic.weatherapp.networking.repository.NetworkRepository
import hr.damirjurkovic.weatherapp.networking.repository.NetworkRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val urlPath: String) {

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl(urlPath).addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): WeatherApiService =
        retrofit.create(WeatherApiService::class.java)

    @Singleton
    @Provides
    fun provideInteractor(service: WeatherApiService): WeatherInteractor =
        WeatherInteractorImpl(service)


    @Provides
    fun provideNetworkRepository(interactor: WeatherInteractor): NetworkRepository {
        return NetworkRepositoryImpl(interactor)
    }

    @Provides
    fun provideWeatherViewModelFactory(): ViewModelProvider.Factory {
        return WeatherViewModelFactory()
    }
}