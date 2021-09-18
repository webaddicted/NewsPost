package com.example.myapplication.global.koin

import com.webaddicted.kotlinproject.global.sharedpref.PreferenceMgr
import com.webaddicted.kotlinproject.global.sharedpref.PreferenceUtils
import org.koin.dsl.module

/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
val commonModelModule = module {
    single { PreferenceUtils() }
    single { PreferenceMgr(get()) }

//    single { AppViewModelFactory() }
//    single { ThemeColors(get(), get()) }
}