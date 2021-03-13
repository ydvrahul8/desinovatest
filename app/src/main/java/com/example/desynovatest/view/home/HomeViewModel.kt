package com.example.desynovatest.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.desynovatest.network.APIRequests
import com.example.desynovatest.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val apiRequests: APIRequests) : ViewModel(){

    fun observeData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiRequests.getData()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Something went wrong"))
        }
    }

}