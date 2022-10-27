package com.example.fruit_app_kotlin_task

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruit_app_kotlin_task.network.FruitApi
import com.example.fruit_app_kotlin_task.response.FruitModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

val TAG = "HomeViewModel_d"

init {
    getFruitProperties()
}

    // todo: update the get CAll & below f() wrt MarsRealStateGrid app
    private fun getFruitProperties() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "getFruitProperties: "+FruitApi.retrofitService.getFruitList())
            } catch (e: Exception) {

            }
        }
    }


}