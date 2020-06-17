package com.eeparking.sun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.eeparking.sun.adapter.GardenPlantingAdapter
import com.eeparking.sun.adapter.PLANT_LIST_PAGE_INDEX
import com.eeparking.sun.databinding.FragmentGardenBinding
import com.eeparking.sun.utils.InjectorUtils
import com.eeparking.sun.viewmodels.GardenPlantingListViewModel

/**
 * @author   linhaidong
 * @datetime 2020-06-10 17:27 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class GardenFragment: Fragment() {

    private lateinit var binding:FragmentGardenBinding

    private val viewModel:GardenPlantingListViewModel by viewModels {
        InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGardenBinding.inflate(inflater,container,false)
        val adapter = GardenPlantingAdapter()
        binding.gardenList.adapter=adapter
        binding.addPlant.setOnClickListener {
            navigateToPlantListPage()
        }
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {
        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner){result ->
            binding.hasPlantings = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }

    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            PLANT_LIST_PAGE_INDEX
    }

}