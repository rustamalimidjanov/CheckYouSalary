package com.example.checkyousalary.presentation

import androidx.lifecycle.ViewModel
import com.example.checkyousalary.data.MonthData
import com.example.checkyousalary.data.MonthRepository

class MonthListViewModel: ViewModel() {
    private val monthRepository = MonthRepository.get()
    val crimeListLiveData = monthRepository.getMonths()

    fun addMonth(month: MonthData){
        monthRepository.addCrime(month = month)
    }
}