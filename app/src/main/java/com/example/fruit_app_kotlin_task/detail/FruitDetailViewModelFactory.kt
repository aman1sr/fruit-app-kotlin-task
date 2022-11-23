package com.example.fruit_app_kotlin_task.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fruit_app_kotlin_task.response.Cdata

class FruitDetailViewModelFactory(
    private val fruitDetail: Cdata,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FruitDetailViewModel::class.java)) {
            return FruitDetailViewModel(fruitDetail,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}