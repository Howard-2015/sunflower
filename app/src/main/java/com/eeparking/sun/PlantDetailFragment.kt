package com.eeparking.sun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eeparking.sun.databinding.FragmentPlantDetailBinding

/**
 * @author   linhaidong
 * @datetime 2020-06-09 17:39 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        binding.apply {
            
        }
        return binding.root
    }
}