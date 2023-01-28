package com.example.checkyousalary.presentation;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.checkyousalary.R
import com.example.checkyousalary.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Callbacks {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_container)

        if (currentFragment == null) {
            val fragment = MonthListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, fragment)
                .commit()
        }

    }

    override fun onMonthSelected(id: UUID) {
        val fragment = MonthFragment.newInstance(crimeId = id)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .addToBackStack(null)
            .commit()

    }
}