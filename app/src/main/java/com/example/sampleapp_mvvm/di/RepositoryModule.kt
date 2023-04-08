package com.example.sampleapp_mvvm.di

import com.example.sampleapp_mvvm.data.api.APIService
import com.example.sampleapp_mvvm.data.repository.Repository
import com.example.sampleapp_mvvm.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: APIService): Repository {
        return RepositoryImpl(apiService)
    }
}