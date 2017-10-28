package es.fabiogomez.weather

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getForeCastBtn = findViewById<Button>(R.id.getForeCastBtn)

        getForeCastBtn.setOnClickListener{
            //println("getForeCastBtn pressed!")

            //var navigateToForecastActivity = Intent(getApplicationContext(), ForecastListViewActivity::class.java)
            var navigateToForecastActivity = Intent(this, ForecastListViewActivity::class.java)
            startActivity(navigateToForecastActivity)
        }
    }
}
