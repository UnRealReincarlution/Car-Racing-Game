package com.example.carracinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.start_button)
        val car_count = findViewById<EditText>(R.id.number_of_cars).text;
        val text_to_change = findViewById<TextView>(R.id.changeMe)

        button.setOnClickListener {
            text_to_change.text = car_count
        }


    }


}