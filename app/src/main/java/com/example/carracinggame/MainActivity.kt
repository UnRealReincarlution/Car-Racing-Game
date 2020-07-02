package com.example.carracinggame

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_menu.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .hide(game_fragment)
            .commit()

        val button = findViewById<Button>(R.id.start_button)
        val car_count = findViewById<EditText>(R.id.number_of_cars).text
        val car_counter = findViewById<EditText>(R.id.number_of_cars)
        val tooltip_text = findViewById<TextView>(R.id.car_count_tooltip)

        button.setOnClickListener {
            car_counter.setVisibility(EditText.GONE)
            button.setVisibility(Button.GONE)
            tooltip_text.setVisibility(TextView.GONE)
            val number_of_cars = car_count.toString().toInt()

            val cars = MutableList(number_of_cars) { Car() }
            for(x in 0 until number_of_cars){
                cars.add(createCar(x))
                print("Creating Car $x")
            }

            runGame(cars)
        }
    }

    private fun createCar(car_number: Int): Car {
        val car = Car()
        car.car_no = car_number
        return car
    }

    private fun runGame(cars: MutableList<Car>) {
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .show(game_fragment)
            .hide(menu_fragment)
            .commit()

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        renderCars(cars)
    }

    private fun renderCars(cars: MutableList<Car>){
        val constraintLayout = findViewById(R.id.game_fragment) as ConstraintLayout

        //for(x in 0 until cars.size){
            val car = ImageView(this)
            car.setImageResource(R.drawable.ic_launcher_background)
            constraintLayout.addView(car)
        //}
    }
}


class Car() {
    private var x: Int = 0
    private var y: Int = 0
    var position: Int = 0
    var car_no: Int = 0
    var finished: Boolean = false
    var placement: Int = 0
}