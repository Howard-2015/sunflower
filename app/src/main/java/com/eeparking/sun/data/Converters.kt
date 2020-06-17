package com.eeparking.sun.data

import androidx.room.TypeConverter
import java.util.*

/**
 * @author   linhaidong
 * @datetime 2020-06-17 15:41 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class Converters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar = Calendar.getInstance().apply {
        timeInMillis = value
    }
}