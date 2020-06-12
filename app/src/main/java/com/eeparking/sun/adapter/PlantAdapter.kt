package com.eeparking.sun.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eeparking.sun.data.Plant
import com.eeparking.sun.databinding.ListItemPlantBinding

/**
 * @author   linhaidong
 * @datetime 2020-06-11 18:34 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantAdapter() : ListAdapter<Plant, RecyclerView.ViewHolder>(PlantDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlantViewHolder(ListItemPlantBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    /**
     * viewholder
     */
     class PlantViewHolder(private val binding: ListItemPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.plant?.let { plant ->
                    navigteToPlant(plant, it)
                }
            }
        }

        private fun navigteToPlant(plant: Plant, it: View?) {
            TODO("Not yet implemented")
        }

        fun bind(item: Plant) {
            binding.apply {
                plant = item
                executePendingBindings()
            }
        }

    }

    /**
     * PlantDiffCallback
     */
    private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.plantId == newItem.plantId
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }

    }
}