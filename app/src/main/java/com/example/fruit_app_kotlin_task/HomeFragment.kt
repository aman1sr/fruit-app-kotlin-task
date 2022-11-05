package com.example.fruit_app_kotlin_task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruit_app_kotlin_task.adapter.FruitAdapter
import com.example.fruit_app_kotlin_task.adapter.FruitsCategoryAdapter
import com.example.fruit_app_kotlin_task.databinding.FragmentHomeBinding
import com.example.fruit_app_kotlin_task.model.Fruits
import com.example.fruit_app_kotlin_task.model.FruitsCategory
import com.example.fruit_app_kotlin_task.response.Cdata
import com.example.fruit_app_kotlin_task.response.FruitModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private val TAG = "Home_d"

    lateinit var fruit: ArrayList<Fruits>

   var fruitListCat :Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)



                    /* Manual way of using Rec */
        viewModel.categorySize.observe(viewLifecycleOwner){

            val adapterFruitCategory = FruitsCategoryAdapter(FruitsCategory.createFruitList(it))
            binding.rvCategoryFruits.adapter = adapterFruitCategory

            Log.d(TAG, "LiveData extracted successfully:::::::")
            viewModel.getfruitList()
        }

        viewModel.fruitList.observe(viewLifecycleOwner){

            var fruitList : FruitModel = it
            var size = fruitList.totalRec

            Log.d(TAG, "Livedata FruitModel: "+fruitList.data.get(0).cdata )

            val fruitSize = fruitList.data.get(0).cdata.size
            var fruitCatfruitList : ArrayList<Fruits> = arrayListOf()

            for (i in 0..fruitSize-1) {
                val name  = fruitList.data.get(0).cdata.get(i).name
                val imgUrl  = fruitList.data.get(0).cdata.get(i).image
                val price  = fruitList.data.get(0).cdata.get(i).sellPrice


                var fruits = Fruits("$name","$imgUrl","$price")
                fruitCatfruitList.add(fruits)
            }

            val adapterFruit = FruitAdapter(fruitCatfruitList)
            binding.rvFruits.adapter = adapterFruit
        }






        binding.rvCategoryFruits.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        binding.rvFruits.layoutManager = LinearLayoutManager(context)



        // Inflate the layout for this fragment
        return binding.root
    }


}