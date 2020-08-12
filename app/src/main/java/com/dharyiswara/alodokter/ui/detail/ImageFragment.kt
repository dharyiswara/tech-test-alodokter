package com.dharyiswara.alodokter.ui.detail

import android.os.Bundle
import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseFragment
import com.dharyiswara.alodokter.helper.TextUtils
import com.dharyiswara.alodokter.helper.loadFromUrl
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : BaseFragment() {

    private lateinit var urlImage: String

    companion object {

        const val URL_IMAGE = "url_image"

        fun newInstance(urlImage: String): ImageFragment {
            val bundle = Bundle()
            bundle.putString(URL_IMAGE, urlImage)
            return ImageFragment().apply {
                arguments = bundle
            }
        }

    }

    override fun getLayoutResId(): Int = R.layout.fragment_image

    override fun initView() {
        super.initView()

        urlImage = arguments?.getString(URL_IMAGE) ?: TextUtils.BLANK

        ivImage?.loadFromUrl(urlImage)
    }

}