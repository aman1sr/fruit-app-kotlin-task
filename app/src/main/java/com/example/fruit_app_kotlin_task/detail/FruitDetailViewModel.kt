package com.example.fruit_app_kotlin_task.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fruit_app_kotlin_task.response.Cdata

class FruitDetailViewModel(fruitData: Cdata, app: Application) : AndroidViewModel(app) {

    private val _fruitDetails = MutableLiveData<Cdata>()
    val fruitDetails : LiveData<Cdata>
    get() = _fruitDetails

    init {
        _fruitDetails.value = fruitData
    }

}