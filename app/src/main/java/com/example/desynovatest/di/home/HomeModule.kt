package com.example.desynovatest.di.home

import com.example.desynovatest.network.APIRequests
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
object HomeModule {

    @HomeScope
    @Provides
    @JvmStatic
    fun provideApiRequest(retrofit: Retrofit): APIRequests {
        return retrofit.create(APIRequests::class.java)
    }
}