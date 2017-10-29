package es.fabiogomez.weather

import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by fabio on 29/10/17.
 */

interface WeatherAPI {

//    @GET("yql?u=c&q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"Sevilla\")%20and%20u=%27c%27&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
@GET("yql?format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast(@Query("q") q: String): Call<Weather>
}

class Weather(val query: WeatherQuery)
class WeatherQuery(val results: WeatherResult)
class WeatherResult(val channel: WeatherChannel)
class WeatherChannel(val title: String, val item: WeatherItem)
class WeatherItem(val forecast: List<Forecast>)
class Forecast(val date: String, val day: String, val high: String, val low:String, val text: String)

class WeatherRetriever {
    val service : WeatherAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://query.yahooapis.com/v1/public/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<Weather>, searchTerm: String) {
        var newSearchTerm = searchTerm

        if (newSearchTerm == "") {
            newSearchTerm = "Barbate"
        }
        val q = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"$newSearchTerm\") and u=\"c\""
        val call = service.getForecast(q)
        call.enqueue(callback)
    }
}