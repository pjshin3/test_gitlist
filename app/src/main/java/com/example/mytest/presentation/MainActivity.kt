package com.example.mytest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytest.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.requestDataSource("pjshin3")
    }
}