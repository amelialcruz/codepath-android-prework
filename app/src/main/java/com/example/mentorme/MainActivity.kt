package com.example.mentorme

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//this kotlin file handles user interaction
class MainActivity : AppCompatActivity() {
    var clickCount = 0

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //shows layout file: activity_main
        setContentView(R.layout.activity_main)

        //declarations
        val showButton = findViewById<Button>(R.id.button3)
        val editText = findViewById<EditText>(R.id.simpleEditText)
        val textView = findViewById<TextView>(R.id.textView)

        //display customized text to show a string
        //button to change text color of label
        //1 - add button to layout

        //reference to button
        //2 - setup logic to know when button is pressed
        findViewById<Button>(R.id.button).setOnClickListener{
            //handles button tap
            //2a - change color of text
            Log.i("mentor.me", "Tapped on button")

            //get reference to text view
            //set color of text
            findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.white))
        }

        //button to change view color
        findViewById<Button>(R.id.button2).setOnClickListener{
            //handles button tap
            //2a - change color of text
            Log.i("mentor.me", "Tapped on button2")

            //get reference to text view
            //set background color
            findViewById<View>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.black))
            clickCount++

            //resets to default views and resets 'clickCount' on 2nd click of 'change view color'
            if (clickCount == 2) {
                clickCount = 0
                findViewById<View>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.light_blue))
                textView.setText("Hello from mentor.me!").toString()
                findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.black))
            }

        }

        //button to change text string
        showButton.setOnClickListener() {
            Log.i("mentor.me", "Tapped on button3")
            val inputValue: String = editText.text.toString()
            if (inputValue == null || inputValue.trim() == "") {
                textView.setText("Hello from mentor.me!").toString()
                Toast.makeText(
                    this,
                    "Please input message, text input cannot be blank",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                findViewById<TextView>(R.id.textView).setText(inputValue).toString()
            }
        }

    }
}