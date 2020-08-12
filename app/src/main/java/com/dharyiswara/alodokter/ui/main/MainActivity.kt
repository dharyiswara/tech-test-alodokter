package com.dharyiswara.alodokter.ui.main

import androidx.fragment.app.Fragment
import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.base.BaseActivity
import com.dharyiswara.alodokter.helper.inTransaction
import com.dharyiswara.alodokter.preferences.UserSession
import com.dharyiswara.alodokter.ui.login.LoginActivity
import com.dharyiswara.alodokter.ui.main.home.HomeFragment
import com.dharyiswara.alodokter.ui.main.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val userSession by inject<UserSession>()

    private val homeFragment by lazy { HomeFragment.newInstance() }

    private val profileFragment by lazy { ProfileFragment.newInstance() }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()

        if (!userSession.isLoggedIn) {
            startActivity<LoginActivity>()
            finish()
        } else {
            replaceFragment(homeFragment)
        }
    }

    override fun initEvent() {
        super.initEvent()
        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId == navigationView.selectedItemId) {
                return@setOnNavigationItemSelectedListener false
            }
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment {
        supportFragmentManager.inTransaction {
            replace(R.id.fragmentLayout, fragment)
        }
    }
}
