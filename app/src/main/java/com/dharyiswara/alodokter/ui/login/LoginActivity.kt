package com.dharyiswara.alodokter.ui.login

import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseActivity
import com.dharyiswara.alodokter.helper.isEmail
import com.dharyiswara.alodokter.preferences.UserSession
import com.dharyiswara.alodokter.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity() {

    private val userSession by inject<UserSession>()

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun initEvent() {
        super.initEvent()

        btnLogin.setOnClickListener {
            if (etEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
                displayMessage(getString(R.string.string_error_empty_email_pass))
            } else if (!etEmail.text.toString().isEmail()) {
                displayMessage(getString(R.string.string_error_email))
            } else {
                doLogin(etEmail.text.toString())
            }
        }
    }

    private fun doLogin(email: String) {
        userSession.email = email
        startActivity<MainActivity>()
        finish()
    }

}