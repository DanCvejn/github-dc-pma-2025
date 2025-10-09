package com.example.toaster

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.toaster.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val showToastButton = findViewById<Button>(R.id.showToast)
        val showSnackbarButton = findViewById<Button>(R.id.showSnackbar)

        showSnackbarButton.setOnClickListener {
            val snackbar = Snackbar.make(
                binding.root,
                "Toto je snackbar",
                Snackbar.LENGTH_SHORT
            ).show()

        }

        showToastButton.setOnClickListener {
            Toast.makeText(this, "Toto je toast", Toast.LENGTH_SHORT).show()
        }
    }
}