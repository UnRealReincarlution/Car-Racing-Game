package com.example.carracinggame

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.start_button)
        val carCount = findViewById<EditText>(R.id.number_of_cars).text

        button.setOnClickListener {
            val fm: FragmentManager = supportFragmentManager
            fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .hide(menu_fragment)
                .commit()

            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

            val numberOfCars = carCount.toString().toInt()

            val cars = MutableList(numberOfCars) { Car() }
//            for(x in 0 until numberOfCars){
//                cars.add(createCar(x))
//                print("Creating Car $x")
//            }

            renderCars(cars)
        }
    }

    private fun createCar(car_number: Int): Car {
        val car = Car()
        car.carNo = car_number
        return car
    }

    fun renderCars(cars: MutableList<Car>){
        val constraintLayout = findViewById<FrameLayout>(R.id.cars)

        //for(x in 0 until cars.size){
            var car: ImageView
            car = ImageView(this)
            car.setImageResource(R.drawable.ic_launcher_background)

//            car.layoutParams.height = 200
//            car.layoutParams.width = 200
            //car.x = 300F
            //car.y = 500F
            //car.setBackgroundColor(Color.MAGENTA)

            constraintLayout.addView(car)
        //}
    }
}

class Car() {
    private var x: Int = 0
    private var y: Int = 0
    var position: Int = 0
    var carNo: Int = 0
    var finished: Boolean = false
    var placement: Int = 0
}
