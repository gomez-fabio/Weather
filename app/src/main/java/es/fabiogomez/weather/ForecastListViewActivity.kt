package es.fabiogomez.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ForecastListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_list_view)

        var forecastListView = findViewById<ListView>(R.id.forecastListView)

        var randomThings: List<String> = listOf("Hello", "How are you", "Nice to meet you", "Hasta la vista")

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,randomThings)

        forecastListView.adapter = adapter
    }
}
