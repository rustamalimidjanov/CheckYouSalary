package com.example.checkyousalary.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MonthData(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var solved: Boolean = false,
)
