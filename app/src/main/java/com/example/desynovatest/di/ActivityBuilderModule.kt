package com.example.desynovatest.di

import com.example.desynovatest.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(
        modules = [
            FragmentBuilderModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}