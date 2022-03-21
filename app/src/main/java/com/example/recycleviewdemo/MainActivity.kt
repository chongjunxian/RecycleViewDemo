package com.example.recycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StudentAdapter.onitemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val studentList = listOf(
        Student("W0001","Alex","RSF2","F"),
        Student("W0002","Alex1","RSF3","M"),
        Student("W0003","Alex2","RSF4","F"),
        Student("W0004","Alex3","RSF5","F"),
        Student("W0005","Alex4","RSF6","M"),
        Student("W0006","Alex5","RSF7","M"),
        Student("W0007","Alex6","RSF8","M")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = StudentAdapter(studentList,this)

        binding.recyclerViewStudent.adapter = adapter
        binding.recyclerViewStudent.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewStudent.setHasFixedSize(true)

    }

    override fun itemClick(position: Int) {
        val selectedStudent = studentList[position]
        Toast.makeText(applicationContext, selectedStudent.name, Toast.LENGTH_SHORT).show()
    }
}