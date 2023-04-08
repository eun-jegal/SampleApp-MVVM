package com.example.sampleapp_mvvm

import android.app.Application
import com.example.sampleapp_mvvm.di.AppComponent
import com.example.sampleapp_mvvm.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}