package com.example.sampleapp_mvvm.di

import com.example.sampleapp_mvvm.data.repository.Repository
import com.example.sampleapp_mvvm.ui.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FactoryModule {

    @Singleton
    @Provides
    fun provideViewModelFactory(repository: Repository): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }
}