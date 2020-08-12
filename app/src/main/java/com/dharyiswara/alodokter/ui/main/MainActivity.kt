package com.dharyiswara.alodokter.ui.main

import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseActivity
import com.dharyiswara.alodokter.preferences.UserSession
import com.dharyiswara.alodokter.ui.login.LoginActivity
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val userSession by inject<UserSession>()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()

        if(!userSession.isLoggedIn){
            startActivity<LoginActivity>()
            finish()
        }
    }
}
