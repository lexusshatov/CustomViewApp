package com.natife.example.customviewapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natife.example.customviewapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, CustomViewFragment.newInstance())
            .commit()
    }
}