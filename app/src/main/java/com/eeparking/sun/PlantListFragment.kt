package com.eeparking.sun

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eeparking.sun.adapter.PlantAdapter
import com.eeparking.sun.databinding.FragmentPlantListBinding
import com.eeparking.sun.viewmodels.PlantListViewModel

/**
 * @author   linhaidong
 * @datetime 2020-06-10 17:28 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantListFragment: Fragment() {

//    private val viewModel:PlantListViewModel by viewModels {
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantListBinding.inflate(inflater,container,false)
        context?:return binding.root

        val adapter = PlantAdapter()
        binding.plantList.adapter=adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
           R.id.filter_zone->{
               updateData()
               true
           }
           else ->super.onOptionsItemSelected(item)
       }
    }

    private fun updateData() {
        TODO("Not yet implemented")
    }

    private fun subscribeUi(adapter: PlantAdapter) {
        TODO()
    }
}