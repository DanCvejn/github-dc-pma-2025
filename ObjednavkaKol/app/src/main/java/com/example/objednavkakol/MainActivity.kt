package com.example.objednavkakol

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.objednavkakol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        title = "Objednávka kola"

        binding.btnOrder.setOnClickListener {
            val bikeRbId = binding.bikes.checkedRadioButtonId
            val bike = findViewById<RadioButton>(bikeRbId)

            val fork = binding.fork.isChecked
            val saddle = binding.saddle.isChecked
            val handleBar = binding.handleBar.isChecked

            val finalOrderText = "Objednávka:\n" +
                    "${bike.text}\n" +
                    (if (fork) "\nLepší vidlice" else "") +
                    (if (saddle) "\nLepší sedlo" else "") +
                    (if (handleBar) "\nLepší řidítka" else "")

            binding.order.text = finalOrderText
        }

        binding.bike1.setOnClickListener {
            binding.image.setImageResource(R.drawable.bike1)
        }
        binding.bike2.setOnClickListener {
            binding.image.setImageResource(R.drawable.bike2)
        }
        binding.bike3.setOnClickListener {
            binding.image.setImageResource(R.drawable.bike3)
        }
    }
}