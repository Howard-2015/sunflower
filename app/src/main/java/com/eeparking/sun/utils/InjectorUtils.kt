package com.eeparking.sun.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.eeparking.sun.data.AppDatabase
import com.eeparking.sun.data.GardenPlantingRepository
import com.eeparking.sun.data.PlantRepository
import com.eeparking.sun.viewmodels.GardenPlantingListViewModelFactory
import com.eeparking.sun.viewmodels.PlantDetailViewModelFactory
import com.eeparking.sun.viewmodels.PlantListViewModelFactory

/**
 * @author   linhaidong
 * @datetime 2020-06-12 18:09 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
object InjectorUtils {
    fun providePlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory {
        var repository = getPlantRepository(fragment.requireContext())
        return PlantListViewModelFactory(repository, fragment)
    }

    private fun getPlantRepository(requireContext: Context): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(requireContext.applicationContext).plantDao()
        )
    }

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return GardenPlantingListViewModelFactory(repository)
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(context).gardenPlantingDao()
        )
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getGardenPlantingRepository(context),
            plantId
        )
    }
}