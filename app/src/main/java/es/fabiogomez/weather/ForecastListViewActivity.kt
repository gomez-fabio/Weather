package es.fabiogomez.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_list_view)

        var retriever = WeatherRetriever()

        val callback = object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {

                title = response?.body()?.query?.results?.channel?.title

                var forecasts = response?.body()?.query?.results?.channel?.item?.forecast

                var forecastStrings = mutableListOf<String>()

                if (forecasts != null) {
                    for (forecast in forecasts) {
                        var newString ="${forecast.day} ${forecast.date} - Max:${forecast.high} Min:${forecast.low} - ${forecast.text}"
                        forecastStrings.add(newString)
                    }
                }

                var forecastListView = findViewById<ListView>(R.id.forecastListView)
                var adapter = ArrayAdapter(this@ForecastListViewActivity,android.R.layout.simple_list_item_1,forecastStrings)
                forecastListView.adapter = adapter
            }
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                println("It doesn´t work")
            }
        }

        val searchTerm = intent.extras.getString("searchTerm")

        retriever.getForecast(callback, searchTerm)
    }
}
