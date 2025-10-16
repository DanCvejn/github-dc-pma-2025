package com.example.sharedpreferences

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.btnSave.setOnClickListener {
            val name = binding.name.text.toString()
            val age = binding.age.text.toString().trim()
            val isAdult = binding.isAdult.isChecked
            if (age.isBlank()) {
                showToast("Věk je povinný údaj")
            } else if ((age.toInt() < 18 && isAdult) || (age.toInt() >= 18 && !isAdult)) {
                showToast("Kecáš, takže nic ukládat nebudu")
            } else {
                showToast("Uložení proběhlo úspěšně")
                editor.apply {
                    putString("name", name)
                    putInt("age", age.toInt())
                    putBoolean("isAdult", isAdult)
                    apply()
                }
            }
        }

        binding.btnLoad.setOnClickListener {
            val name = sharedPreferences.getString("name", "")
            val age = sharedPreferences.getInt("age", 0)
            val isAdult = sharedPreferences.getBoolean("isAdult", false)
            binding.name.setText(name)
            binding.age.setText(age.toString())
            binding.isAdult.isChecked = isAdult
            showToast("Načítání proběhlo úspěšně")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}