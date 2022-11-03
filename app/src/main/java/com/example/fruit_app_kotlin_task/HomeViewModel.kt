package com.example.fruit_app_kotlin_task

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruit_app_kotlin_task.model.Fruits
import com.example.fruit_app_kotlin_task.model.FruitsCategory
import com.example.fruit_app_kotlin_task.network.FruitApi
import com.example.fruit_app_kotlin_task.response.FruitModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val TAG = "HomeViewModel_d"

    lateinit var fruitsCategories: ArrayList<FruitsCategory>

//    lateinit var categorySize: Int        // todo: why not??


    var categorySize: Int = 0



    init {
        getFruitProperties()
    }

    fun getFruitCategoryList(): ArrayList<FruitsCategory>{
        fruitsCategories = FruitsCategory.createFruitList(categorySize)       // to here <-- put in data via API

        return fruitsCategories
    }



    private fun getFruitProperties() {

        viewModelScope.launch {
            try {
                Log.d(
                    TAG, "getFruitProperties: " + FruitApi.retrofitService.getFruitList().totalRec   )   // it will get a singleton Retrofit object that implements FruitApiService

                categorySize = FruitApi.retrofitService.getFruitList().totalRec!!

            } catch (e: Exception) {
                Log.d(TAG, "crashhhh>>> " + e.localizedMessage)
            }
        }
    }

}