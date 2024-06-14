package com.example.lab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val studentParam = intent.getParcelableExtra<Student>("student")
        if (studentParam != null) {
            binding.firstName.setText(student.firstName)
            binding.lastName.setText(student.lastName)
            binding.address.setText(student.lastName)
        }

        student = Student("Name", "Surname", "Address")
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("student", Student(binding.firstName.text.toString(), binding.lastName.text.toString(), binding.address.text.toString()))
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("student", student)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        student = savedInstanceState.getParcelable("student")!!
    }
}