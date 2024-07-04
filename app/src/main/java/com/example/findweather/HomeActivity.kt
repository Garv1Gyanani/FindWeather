package com.example.findweather

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.findweather.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        fetchWeatherData("jaipur")
        setupSearch()
    }

    private fun setupSearch() {
        val searchView = binding.searchbox
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun fetchWeatherData(cityName: String) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(Appinterface::class.java)

        val response = retrofit.getWeatherData(cityName, "c622db2dee1a4bde73588b18134f1fff", "metric")

        response.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val temp = responseBody.main.temp.toString()
                    val humidity = responseBody.main.humidity.toString()
                    val windSpeed = responseBody.wind.speed

                    val seaLevel = responseBody.main.sea_level
                    val condition = responseBody.weather.firstOrNull()?.main ?: "unknown"
                    val tempMax = responseBody.main.temp_max
                    val tempMin = responseBody.main.temp_min

                    binding.texttemp.text = "$temp °C"
                    binding.condition.text = condition
                    binding.max.text = "Max: $tempMax °C"
                    binding.min.text = "Min: $tempMin °C"
                    binding.textwind.text = "$windSpeed M/S"
                    binding.texthumi.text="$humidity"
                    binding.textsea.text = "$seaLevel HPA"
                    binding.textcondi.text = condition
                    binding.day.text = day(System.currentTimeMillis())
                    binding.date.text = date()
                    binding.location.text = cityName




                }
            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                // Handle failure
                t.printStackTrace()
            }
        })
    }

    private fun date(): String {
        val sdf = SimpleDateFormat("EEE MMMM yyyy", Locale.getDefault())
        return sdf.format(Date())
    }

    private fun day(timestamp: Long): String {
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
