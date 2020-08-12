package com.dharyiswara.alodokter.ui.detail

import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseActivity
import com.dharyiswara.alodokter.model.Images
import kotlinx.android.synthetic.main.activity_detail_image.*

class DetailImageActivity : BaseActivity() {

    private val fragmentAdapter = ImageFragmentAdapter(supportFragmentManager)

    private var imageList = listOf<Images>()

    private var indexImage = 0

    companion object {

        const val IMAGES = "images"
        const val INDEX_IMAGES = "index"

    }

    override fun getLayoutResId(): Int = R.layout.activity_detail_image

    override fun initView() {
        super.initView()

        imageList = intent.getSerializableExtra(IMAGES) as List<Images>
        indexImage = intent.getIntExtra(INDEX_IMAGES, 0)

        pagerImage.adapter = fragmentAdapter
        dotImage.setupWithViewPager(pagerImage)

        imageList.forEach {
            fragmentAdapter.addFragment(ImageFragment.newInstance(it.url))
        }
        fragmentAdapter.notifyDataSetChanged()

        pagerImage.currentItem = indexImage
    }

}