package com.example.desynovatest.di

import com.example.desynovatest.di.home.HomeModule
import com.example.desynovatest.di.home.HomeScope
import com.example.desynovatest.di.home.HomeViewModelModule
import com.example.desynovatest.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilderModule {
    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            HomeViewModelModule::class,
            HomeModule::class]
    )
    fun contributeHomeFragment(): HomeFragment
}