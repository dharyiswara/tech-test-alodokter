package com.dharyiswara.alodokter.application

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class AlodokterApp : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
    }

}