package com.example.fruit_app_kotlin_task.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fruit_app_kotlin_task.response.Cdata
import kotlin.properties.Delegates

class FruitDetailViewModel(fruitData: Cdata, app: Application) : AndroidViewModel(app) {

    private val _fruitDetails = MutableLiveData<Cdata>()
    val fruitDetails: LiveData<Cdata>
        get() = _fruitDetails

    private val _fruitCartQty = MutableLiveData<Int>()
    val fruitCartQty: LiveData<Int>
        get() = _fruitCartQty


    var tax: Double = 18.0
    var deliveryRate: Double = 50.0

    var xyz by Delegates.notNull<Int>()

    /*Top Screen UI */
    lateinit var str_topView_fruitName: String
    lateinit var str_topView_fruitDesc: String
    lateinit var str_topView_TotalQty: String
    lateinit var str_topView_farmerName: String
    lateinit var str_topView_FarmerCompany: String
    lateinit var sellPrice: String
    lateinit var str_topView_sellPrice: String


    /* Bottom Calc UI */
    private val _fruitSubTotal = MutableLiveData<String>()
    val fruitSubTotal: LiveData<String>
        get() = _fruitSubTotal

    private val _fruitFinalTotal = MutableLiveData<String>()
    val fruitFinalTotal :LiveData<String>
    get() = _fruitFinalTotal

    init {
        _fruitDetails.value = fruitData
        _fruitCartQty.value = 1

        str_topView_fruitName = fruitData.name.toString()
        str_topView_fruitDesc = fruitData.description.toString()
        str_topView_TotalQty = fruitData.totalQty.toString() + " Qty"
        str_topView_farmerName = fruitData.farmerName.toString()
        str_topView_FarmerCompany = fruitData.farmerCompany.toString()
        sellPrice = fruitData.sellPrice.toString()
        str_topView_sellPrice = "Price: " + sellPrice + " ₹"


    }

    fun addQty() {
        _fruitCartQty.value = _fruitCartQty.value?.plus(1)
        trackFruitCalc()
    }

    fun minusQty() {
        if (_fruitCartQty.value != 1) {
            _fruitCartQty.value = _fruitCartQty.value?.minus(1)
            trackFruitCalc()
        }
    }

    private fun trackFruitCalc() {
        // Calc. Subtotal
        var subTotal = _fruitCartQty.value?.times(sellPrice.toDouble())
        _fruitSubTotal.value = String.format("%.2f",subTotal)

        // Calc. final total = subtotal + tax + deliveryRate
        var taxAmt = (tax/100)* subTotal!!
        var totalAmt = taxAmt + deliveryRate + subTotal;
        _fruitFinalTotal.value = String.format("%.2f",totalAmt)

    }

    companion object {
        private const val TAG = "FruitDetailVM_d"
    }


}