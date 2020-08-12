package com.dharyiswara.alodokter.base

interface BaseView {

    fun getLayoutResId(): Int

    fun initView()

    fun initEvent()

    fun loadingData(isFromSwipe: Boolean = false)

    fun successLoadData()

}