package com.example.mytest

import android.app.Application
import com.example.mytest.di.networkModule
import com.example.mytest.di.useCaseModule
import com.example.mytest.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    useCaseModule,
                    viewmodelModule
                )
            )
        }
    }
}