package com.eeparking.sun.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eeparking.sun.data.GardenPlantingRepository
import com.eeparking.sun.data.PlantRepository

/**
 * @author   linhaidong
 * @datetime 2020-06-17 17:13 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantDetailViewModelFactory(
    private val plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId:String
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantRepository,gardenPlantingRepository,plantId) as T
    }

}