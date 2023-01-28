package com.example.checkyousalary.data

import android.app.Application

class MonthIntentApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MonthRepository.initialize(this)
    }
}