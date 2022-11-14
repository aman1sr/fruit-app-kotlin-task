package com.example.fruit_app_kotlin_task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruit_app_kotlin_task.adapter.FruitsCategoryAdapter

import com.example.fruit_app_kotlin_task.network.FruitApi
import com.example.fruit_app_kotlin_task.response.Cdata
import com.example.fruit_app_kotlin_task.response.Data
import com.example.fruit_app_kotlin_task.response.FruitModel
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.NetworkState
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val TAG = "HomeViewModel_d"
//   lateinit var categorySize: Int        // todo: why not??

    private lateinit var adapterFruitCategory: FruitsCategoryAdapter


    /* to Load Progress bar */
    val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading


    /* to Extract Fruit data */
    private var _fruitList = MutableLiveData<FruitModel>()
    val fruitList: LiveData<FruitModel>
        get() = _fruitList

    /* to Observe the Fruit list based on Fruit Cat Click */
    private var _subFruitList = MutableLiveData<ArrayList<Cdata>>()
    val subFruitList: LiveData<ArrayList<Cdata>>
    get() = _subFruitList


    init {
        getfruitList()
        _loading.value = true
    }

    fun getfruitList() {
        viewModelScope.launch {
            _fruitList.value = FruitApi.retrofitService.getFruitList()
            _loading.value = false
        }
    }

    fun getSubFruitList( fruitList: ArrayList<Cdata>) {
        _subFruitList.value = fruitList!!
    }

}