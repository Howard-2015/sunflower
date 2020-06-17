package com.eeparking.sun.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eeparking.sun.data.GardenPlantingRepository
import com.eeparking.sun.data.PlantAndGardenPlantings

/**
 * @author   linhaidong
 * @datetime 2020-06-16 14:56 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}