package com.dharyiswara.alodokter.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ImageFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = mutableListOf<Fragment>()

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment:Fragment) {
        fragmentList.add(fragment)
    }

}