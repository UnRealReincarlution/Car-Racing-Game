package com.example.carracinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.start_button)
        val car_count = findViewById<EditText>(R.id.number_of_cars).text
        val car_counter = findViewById<EditText>(R.id.number_of_cars)
        val text_to_change = findViewById<TextView>(R.id.changeMe)
        val tooltip_text = findViewById<TextView>(R.id.car_count_tooltip)

        button.setOnClickListener {
            text_to_change.text = "$car_count Cars"
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
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        //transaction.replace(R.id.mainPage, R.layout.game_activity)
        transaction.commit()

        renderCars(cars)
    }

    private fun renderCars(cars: MutableList<Car>){

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