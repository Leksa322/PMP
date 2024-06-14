package com.example.lab_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.lab_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            showText("btn1 clicked")
        }

        binding.btn2.setOnClickListener {
            showText("btn2 clicked")
        }

        binding.eT1.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showText("eT1 focused")
            } else {
                showText("eT1 lost focus")
            }
        }

        binding.eT2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (!s.isNullOrEmpty()) {
                    val message = "Before text changed eT2"
                    showText(message)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    val message = "Text changed eT2"
                    showText(message)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                binding.eT1.setText(s.toString())
            }
        })
    }

    private fun showText(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}