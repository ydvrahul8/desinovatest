package com.example.desynovatest.view

import com.example.desynovatest.R
import com.example.desynovatest.base.BaseActivity
import com.example.desynovatest.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layout: Int
        get() = R.layout.activity_main

    override fun init(bind: ActivityMainBinding) {
    }
}