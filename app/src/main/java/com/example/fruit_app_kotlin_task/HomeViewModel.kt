package com.example.fruit_app_kotlin_task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.fruit_app_kotlin_task.network.FruitApi
import com.example.fruit_app_kotlin_task.response.Data
import com.example.fruit_app_kotlin_task.response.FruitModel
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.NetworkState
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val TAG = "HomeViewModel_d"

//    lateinit var fruitsCategories: ArrayList<FruitsCategory>


//    lateinit var fruitsCategories: MutableList<FruitsCategory>        // todo: how to ??

//    lateinit var categorySize: Int        // todo: why not??

//    var fruitsCategories = mutableListOf<FruitsCategory>()        // to use in future

//    fun setFruitCatList(fruitCat: ArrayList<FruitsCategory>) {
//        this.fruitsCategories = fruitCat
//    }


    private var _fruitList = MutableLiveData<FruitModel>()
    val fruitList: LiveData<FruitModel>
    get() = _fruitList

    val loading = MutableLiveData<Boolean>()



    init {
        getfruitList()
    }

    fun getfruitList(){
        viewModelScope.launch {
            _fruitList.value = FruitApi.retrofitService.getFruitList()
        }
    }



}