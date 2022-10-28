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

    private fun getFruitProperties() {
  FruitApi.retrofitService.getFruitList().enqueue(
      object :Callback<String>{
          override fun onResponse(call: Call<String>, response: Response<String>) {
              Log.d(TAG, "onResponse: "+response.body().toString()
              )
          }

          override fun onFailure(call: Call<String>, t: Throwable) {
              Log.d(TAG, "onFailure:>> "+call.toString()
              )
          }

      }
  )
    }


}