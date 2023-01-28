package com.example.checkyousalary.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MonthData::class], version = 1)
@TypeConverters(MonthTypeConverters::class)
abstract class MonthDatabase: RoomDatabase() {

    abstract fun monthDao(): MonthDao


}