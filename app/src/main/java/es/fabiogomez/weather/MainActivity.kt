package es.fabiogomez.weather

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getForeCastBtn = findViewById<Button>(R.id.getForeCastBtn)
        getForeCastBtn.setOnClickListener{
            var navigateToForecastActivity = Intent(this, ForecastListViewActivity::class.java)
            val searchEditText = findViewById<EditText>(R.id.searchEditText)
            navigateToForecastActivity.putExtra("searchTerm", searchEditText.text.toString())
            startActivity(navigateToForecastActivity)
        }
    }
}
