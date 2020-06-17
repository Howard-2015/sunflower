package com.eeparking.sun.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eeparking.sun.data.Plant

/**
 * @author   linhaidong
 * @datetime 2020-06-12 14:40 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
@Dao
interface PlantDao {
    @Query("SELECT * FROM plants ORDER BY name")
    fun getPlants():LiveData<List<Plant>>

    @Query("SELECT * FROM plants WHERE growZoneNumber= :growZoneNumber ORDER BY name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber:Int):LiveData<List<Plant>>

    @Query("SELECT * FROM plants WHERE id= :plantId")
    fun getPlant(plantId: String):LiveData<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants:List<Plant>)
}