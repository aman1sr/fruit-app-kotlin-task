package com.example.fruit_app_kotlin_task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruit_app_kotlin_task.model.Fruits
import com.example.fruit_app_kotlin_task.model.FruitsCategory
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

    private var _categorySize = MutableLiveData<Int>()
    val categorySize : LiveData<Int>
    get() = _categorySize

    private var _fruitList = MutableLiveData<FruitModel>()
    val fruitList: LiveData<FruitModel>
    get() = _fruitList

    val loading = MutableLiveData<Boolean>()



    init {
        getfruitList()
    }

//    fun getFruitCategoryList(): ArrayList<FruitsCategory>{
//        fruitsCategories = FruitsCategory.createFruitList(7)       // to here <-- put in data via API
//
//        return fruitsCategories
//    }

    fun getfruitList(){
        viewModelScope.launch {
            _fruitList.value = FruitApi.retrofitService.getFruitList()
        }
    }


    private fun getFruitProperties() {

        viewModelScope.launch {
            try {
                Log.d(TAG, "getFruitProperties: " + FruitApi.retrofitService.getFruitList().totalRec  )   // it will get a singleton Retrofit object that implements FruitApiService

                _categorySize.value  = FruitApi.retrofitService.getFruitList().totalRec!!


//                fruitListCat = FruitApi.retrofitService.getFruitList()


            } catch (e: Exception) {
                Log.d(TAG, "crashhhh>>> " + e.localizedMessage)
            }
        }
    }

}