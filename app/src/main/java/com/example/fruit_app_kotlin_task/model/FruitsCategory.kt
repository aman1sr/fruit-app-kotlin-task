package com.example.fruit_app_kotlin_task.model

import android.provider.ContactsContract.Contacts
import com.example.fruit_app_kotlin_task.adapter.FruitsCategoryAdapter

class FruitsCategory(val fruitName: String, val ImgUrl: String) {
    companion object{
        private var lastFruitId = 0

        fun createFruitList(numFruits: Int): ArrayList<FruitsCategory> {
            val fruits = ArrayList<FruitsCategory>()

            for (i in 1..numFruits) {
                fruits.add(FruitsCategory("Aman"+ ++lastFruitId, "xyz" ))
            }

            return fruits
        }
    }
}