package com.example.fruit_app_kotlin_task.model

class Fruits(val fruitName: String, val ImgURL: String, val fruitPrice: Int) {

    companion object{
        private var fruitID = 0

        fun createFruitList(numFruit: Int) : ArrayList<Fruits>{
            val fruit = ArrayList<Fruits>()

            for (i in 1..numFruit) {
                val random = (10..100).random()
                fruit.add(Fruits("Aman"+ ++fruitID , "xyz", fruitID*random))
            }

            return fruit
        }
    }
}