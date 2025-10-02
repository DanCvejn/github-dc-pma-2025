package com.example.customlayout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Buttons
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnDelete = findViewById<Button>(R.id.btnRemove)

        val number = findViewById<TextView>(R.id.number)

        val btns = listOf<Button>(
            findViewById<Button>(R.id.btnOne),
            findViewById<Button>(R.id.btnTwo),
            findViewById<Button>(R.id.btnThree),
            findViewById<Button>(R.id.btnFour),
            findViewById<Button>(R.id.btnFive),
            findViewById<Button>(R.id.btnSix),
            findViewById<Button>(R.id.btnSeven),
            findViewById<Button>(R.id.btnEight),
            findViewById<Button>(R.id.btnNine),
            findViewById<Button>(R.id.btnZero)
        )

        btns.forEach { button ->
            button.setOnClickListener {
                number.text = number.text.toString() + button.text.toString()
            }
        }

        btnDelete.setOnClickListener {
            number.text = number.text.toString().dropLast(1);
        }

        btnCall.setOnClickListener {
            if (number.text.toString() !== "") {
                val dialogTitle = "Volání"
                val dialogMessage = number.text.toString()
                val confirmationDialog = ConfirmationDialogFragment.newInstance(dialogTitle, dialogMessage)
                number.text = ""

                confirmationDialog.show(supportFragmentManager, "ConfirmationDialog")
            }
        }
    }
}