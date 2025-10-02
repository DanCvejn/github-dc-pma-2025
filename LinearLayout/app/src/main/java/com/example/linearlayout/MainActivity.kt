package com.example.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } */

        val firstnameEl = findViewById<EditText>(R.id.firstname);
        val lastnameEl = findViewById<EditText>(R.id.lastname);
        val cityEl = findViewById<EditText>(R.id.city);
        val ageEl = findViewById<EditText>(R.id.age);
        val noteEl = findViewById<TextView>(R.id.note);
        val btnSend = findViewById<Button>(R.id.button_send);
        val btnDelete = findViewById<Button>(R.id.button_delete);

        btnSend.setOnClickListener {
            val name = firstnameEl.text.toString() + ' ' + lastnameEl.text.toString();
            val city = cityEl.text.toString();
            val age = ageEl.text.toString();

            val finalText = "Jméno: $name\nMěsto: $city\nVěk: $age";
            noteEl.text = finalText;
        }

        btnDelete.setOnClickListener {
            firstnameEl.text.clear();
            lastnameEl.text.clear();
            cityEl.text.clear();
            ageEl.text.clear();
            noteEl.text = "";
        }
    }
}