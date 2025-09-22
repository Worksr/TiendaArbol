package com.example.datacore

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromDate(value:String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it,formatter) }
    }
    //A este se la da el formato de iso local date time
    @TypeConverter
    fun dateToString(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }
}