package com.eeparking.sun.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eeparking.sun.data.GardenPlantingRepository

/**
 * @author   linhaidong
 * @datetime 2020-06-16 17:54 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class GardenPlantingListViewModelFactory(
    private val repository: GardenPlantingRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECK_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }

}