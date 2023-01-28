package com.example.checkyousalary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface MonthDao {
    @Query("SELECT * FROM monthdata")
    fun getMonths(): LiveData<List<MonthData>>

    @Query("SELECT * FROM monthdata WHERE id=(:id)")
    fun getMonth(id: UUID): LiveData<MonthData?>

    @Update
    fun updateMonth(month: MonthData)

    @Insert
    fun addMonth(month: MonthData)


}