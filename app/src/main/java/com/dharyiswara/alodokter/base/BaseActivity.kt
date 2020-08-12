package com.dharyiswara.alodokter.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        initEvent()
        loadingData()
    }

    override fun initView() {}

    override fun initEvent() {}

    override fun loadingData(isFromSwipe: Boolean) {}

    override fun successLoadData() {}

    protected fun displayMessage(message: String?) {
        getParentViewGroup()?.let { vg ->
            message?.let { Snackbar.make(vg, it, Snackbar.LENGTH_SHORT).show() }
        }
    }

    private fun decorViewGroup(): ViewGroup? {
        return when (isDecorViewGroup()) {
            true -> window.decorView as ViewGroup
            else -> null
        }
    }

    private fun isDecorViewGroup(): Boolean {
        return window.decorView is ViewGroup
    }

    private fun getParentViewGroup(): ViewGroup? = decorViewGroup()

}