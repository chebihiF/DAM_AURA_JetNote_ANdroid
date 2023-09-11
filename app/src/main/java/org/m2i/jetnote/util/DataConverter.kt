package org.m2i.jetnote.util

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class DataConverter {

    @TypeConverter
    fun timestampFromDate(date: Date) : Long {
        return  date.time
    }

    @TypeConverter
    fun dateFromTimestamp(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String): UUID? {
        return UUID.fromString(string)
    }


}