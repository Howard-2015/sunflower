package com.eeparking.sun.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author   linhaidong
 * @datetime 2020-06-12 10:38 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name="id")
    val plantId:String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl:String = ""
    ) {

}