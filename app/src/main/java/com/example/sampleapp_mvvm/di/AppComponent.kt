package com.example.sampleapp_mvvm.di

import com.example.sampleapp_mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetModule::class,
        FactoryModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}