package com.example.myapplication.global

import android.app.Application
import android.content.res.Resources
import com.example.myapplication.global.koin.appModule
import com.example.myapplication.global.koin.commonModelModule
import com.example.myapplication.global.koin.repoModule
import com.example.myapplication.global.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class AppApplication : Application() {

    companion object {
        lateinit var res: Resources
    }

    override fun onCreate() {
        super.onCreate()
        res = resources
//        context = this
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(getModule())
        }
    }

    private fun getModule(): List<Module> {
        return listOf(
                appModule,
                commonModelModule,
                viewModelModule,
                repoModule
        )
    }
}
