package com.dharyiswara.alodokter.preferences

import android.content.Context
import com.dharyiswara.alodokter.helper.TextUtils

class UserSession(context: Context) {

    companion object {
        const val PREFERENCE_NAME = "user"
        const val EMAIL = "email"
    }

    private val sharedPreference =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    var email: String
        get() = sharedPreference.getString(EMAIL, TextUtils.BLANK) ?: TextUtils.BLANK
        set(name) = sharedPreference.edit().putString(EMAIL, name).apply()

    var isLoggedIn: Boolean = false
        get() = sharedPreference.getString(EMAIL, TextUtils.BLANK)?.isNotEmpty() ?: false

    fun logout() {
        sharedPreference.edit().clear().apply()
    }
}