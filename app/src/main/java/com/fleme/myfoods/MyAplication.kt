package com.fleme.myfoods

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.fleme.myfoods.di.FoodModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyAplication: Application() {

    private val module = FoodModule.instance

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyAplication)
            modules(module)
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}