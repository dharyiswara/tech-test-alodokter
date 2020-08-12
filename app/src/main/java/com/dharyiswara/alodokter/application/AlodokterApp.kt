package com.dharyiswara.alodokter.application

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.dharyiswara.alodokter.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AlodokterApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
        startKoin {
            androidContext(this@AlodokterApp)
            modules(commonModule)
        }
    }

}