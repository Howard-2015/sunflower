package com.eeparking.sun

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.eeparking.sun.adapter.MY_GARDEN_PAGE_INDEX
import com.eeparking.sun.adapter.PLANT_LIST_PAGE_INDEX
import com.eeparking.sun.adapter.SunflowerPagerAdapter
import com.eeparking.sun.databinding.FragmentHomeViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IndexOutOfBoundsException

/**
 * @author   linhaidong
 * @datetime 2020-06-09 17:35 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class HomeViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager
        //设置viewpager-adapter
        viewPager.adapter = SunflowerPagerAdapter(this)
        //关联tablayout和viewpager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> getString(R.string.my_garden_title)
            PLANT_LIST_PAGE_INDEX -> getString(R.string.plant_list_title)
            else -> null
        }

    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }

    }
}