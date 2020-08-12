package com.dharyiswara.alodokter.ui.main.profile

import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseFragment

class ProfileFragment : BaseFragment() {

    companion object {

        fun newInstance(): ProfileFragment = ProfileFragment()

    }

    override fun getLayoutResId(): Int = R.layout.fragment_home

}