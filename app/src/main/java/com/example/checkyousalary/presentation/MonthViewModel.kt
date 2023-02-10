package com.example.checkyousalary.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.checkyousalary.data.MonthData
import com.example.checkyousalary.data.MonthRepository
import java.util.*

class MonthViewModel(): ViewModel() {
    private val monthRepository = MonthRepository.get()
    private val monthIdLiveData = MutableLiveData<UUID>()
    var monthLiveData: LiveData<MonthData?> =
        Transformations.switchMap(monthIdLiveData) { id ->
            monthRepository.getMonth(id = id)
        }

    fun loadMonth(monthId: UUID){
        monthIdLiveData.value = monthId
    }
    fun saveMonth(month: MonthData){
        monthRepository.updateMonth(month = month)
    }
}