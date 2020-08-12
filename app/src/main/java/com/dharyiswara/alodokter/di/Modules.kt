package com.dharyiswara.alodokter.di

import com.dharyiswara.alodokter.preferences.UserSession
import org.koin.dsl.module

val commonModule = module {

    single { UserSession(get()) }

}