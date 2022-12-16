package com.example.fruit_app_kotlin_task.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fruit_app_kotlin_task.response.Cdata
import kotlin.properties.Delegates

class FruitDetailViewModel(fruitData: Cdata, app: Application) : AndroidViewModel(app) {

    private val _fruitDetails = MutableLiveData<Cdata>()
    val fruitDetails : LiveData<Cdata>
    get() = _fruitDetails

    private val _fruitCartQty = MutableLiveData<Int>()
    val fruitCartQty : LiveData<Int>
    get() = _fruitCartQty

     var sellPrice: Double = 1.0       // to check best way to intialize

     var tax: Double =18.0
     var deliveryRate: Double = 50.0

    var xyz by Delegates.notNull<Int>()

    lateinit var str_topView_fruitName: String
    lateinit var str_topView_fruitDesc: String
    lateinit var str_topView_TotalQty: String
    lateinit var str_topView_farmerName: String
    lateinit var str_topView_FarmerCompany: String

    init {
        _fruitDetails.value = fruitData
        _fruitCartQty.value = 1

        str_topView_fruitName = fruitData.name.toString()
        str_topView_fruitDesc = fruitData.description.toString()
        str_topView_TotalQty = fruitData.totalQty.toString() +" Qty"
        str_topView_farmerName = fruitData.farmerName.toString()
        str_topView_FarmerCompany = fruitData.farmerCompany.toString()

    }

    fun addQty() {
        _fruitCartQty.value = _fruitCartQty.value?.plus(1)

    }
  fun minusQty() {
      if (_fruitCartQty.value != 1)
        _fruitCartQty.value = _fruitCartQty.value?.minus(1)
    }



}