package com.daviddev.passwordmanager.room

import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converter {
    @TypeConverter
    fun fromDate(date: LocalDateTime): String {
        return date.toString()
    }

    @TypeConverter
    fun toDate(date: String): LocalDateTime {
        return LocalDateTime.parse(date)
    }
}