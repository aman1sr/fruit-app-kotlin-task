package com.example.fruit_app_kotlin_task

import android.os.Bundle
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

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    lateinit var fruit: ArrayList<Fruits>

   var fruitListCat :Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        fruit = Fruits.createFruitList(10)


        viewModel.categorySize.observe(viewLifecycleOwner){

            val adapterFruitCategory = FruitsCategoryAdapter(FruitsCategory.createFruitList(it))
            binding.rvCategoryFruits.adapter = adapterFruitCategory
        }



        val adapterFruit = FruitAdapter(fruit)
        binding.rvFruits.adapter = adapterFruit


        binding.rvCategoryFruits.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        binding.rvFruits.layoutManager = LinearLayoutManager(context)



        // Inflate the layout for this fragment
        return binding.root
    }


}