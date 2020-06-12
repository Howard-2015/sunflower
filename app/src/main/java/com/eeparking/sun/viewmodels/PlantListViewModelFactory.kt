package com.eeparking.sun.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.eeparking.sun.data.repository.PlantRepository
import java.security.acl.Owner

/**
 * @author   linhaidong
 * @datetime 2020-06-12 18:10 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantListViewModelFactory(
    private val repository: PlantRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs:Bundle?=null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return PlantListViewModel(repository,handle) as T
    }

}