package com.eeparking.sun.viewmodels

import com.eeparking.sun.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author   linhaidong
 * @datetime 2020-06-16 18:19 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantAndGardenPlantingsViewModel(
    plantings: PlantAndGardenPlantings
) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlanting.lastWateringDate.time)
    val wateringInterval get() = plant.wateringInterval
    val imageUrl get() = plant.imageUrl
    val plantName get() = plant.name
    val plantDateString: String = dateFormat.format(gardenPlanting.plantDate.time)
    val plantId get() = plant.plantId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
    }
}