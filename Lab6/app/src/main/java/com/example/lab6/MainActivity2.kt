package com.example.lab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val student = intent.getParcelableExtra<Student>("student")

        if (student != null) {
            binding.textView.setText("FirstName: ${student.firstName}\nLastName: ${student.lastName}\n" +
                    "Address: ${student.address}")
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }
    }
}