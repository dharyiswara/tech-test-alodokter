package com.dharyiswara.alodokter.ui.main.profile

import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseFragment
import com.dharyiswara.alodokter.helper.loadFromUrl
import com.dharyiswara.alodokter.preferences.UserSession
import com.dharyiswara.alodokter.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject

class ProfileFragment : BaseFragment() {

    private val userSession by inject<UserSession>()

    companion object {

        fun newInstance(): ProfileFragment = ProfileFragment()

    }

    override fun getLayoutResId(): Int = R.layout.fragment_profile

    override fun initView() {
        super.initView()

        ivAvatar.loadFromUrl("https://avatarfiles.alphacoders.com/139/thumb-139523.jpg")
        tvName.text = getString(R.string.string_username)
        tvGender.text = getString(R.string.string_gender_male)
        tvPhoneNumber.text = getString(R.string.string_phone_number)
    }

    override fun initEvent() {
        super.initEvent()
        tvLogout.setOnClickListener {
            userSession.logout()
            startActivity<LoginActivity>()
            requireActivity().finish()
        }
    }

}