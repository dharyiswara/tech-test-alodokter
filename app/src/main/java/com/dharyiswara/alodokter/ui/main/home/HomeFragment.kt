package com.dharyiswara.alodokter.ui.main.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val imageAdapter = HomeImageAdapter()

    private val presenter by lazy { HomePresenter(this) }

    companion object {

        fun newInstance(): HomeFragment = HomeFragment()

    }

    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initView() {
        super.initView()

        with(rvImage) {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun loadingData(isFromSwipe: Boolean) {
        super.loadingData(isFromSwipe)
        presenter.loadImage()
    }

    override fun successLoadData() {
        super.successLoadData()
        imageAdapter.replaceData(presenter.getImageList())
    }

}