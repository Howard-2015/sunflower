package com.eeparking.sun.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author   linhaidong
 * @datetime 2020-06-16 17:37 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
data class PlantAndGardenPlantings (
    @Embedded
    val plant: Plant,

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantings: List<GardenPlanting> = emptyList()
)