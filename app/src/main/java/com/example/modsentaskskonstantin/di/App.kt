package com.example.modsentaskskonstantin.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
<<<<<<< task-1-1
            modules(listOf(dataModule, domainModule, uiModule, retrofitModule()))
=======
            modules(listOf(dataModule, domainModule, uiModule))
>>>>>>> main
        }
    }
}
