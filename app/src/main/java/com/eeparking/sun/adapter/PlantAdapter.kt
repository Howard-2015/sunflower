package com.eeparking.sun.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author   linhaidong
 * @datetime 2020-06-11 18:34 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantAdapter() : ListAdapter<T, RecyclerView.ViewHolder>() {



    private class PlantDiffCallback: DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            TODO("Not yet implemented")
        }

    }
}