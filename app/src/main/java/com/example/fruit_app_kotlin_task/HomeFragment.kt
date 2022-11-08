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

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private val TAG = "Home_d"

    lateinit var fruit: ArrayList<Fruits>

    private lateinit var adapterFruitCategory: FruitsCategoryAdapter

    var fruitListCat: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        /* Manual way of using Rec */
        viewModel.categorySize.observe(viewLifecycleOwner) {

//            val adapterFruitCategory = FruitsCategoryAdapter(FruitsCategory.createFruitList(it))
//            binding.rvCategoryFruits.adapter = adapterFruitCategory

        }

        viewModel.fruitList.observe(viewLifecycleOwner) {

            val fruitList: FruitModel = it



//         todo: clickListener performed -> show RecView
            adapterFruitCategory = FruitsCategoryAdapter(FruitsCategoryAdapter.OnClickListener {
                Log.d(TAG, "clickedddddddddd>>> ")


                var fruitList = it

                val adapterFruit = FruitAdapter(fruitList)
                binding.rvFruits.adapter = adapterFruit

            })


            adapterFruitCategory.submitList(fruitList?.data)
            binding.rvCategoryFruits.adapter = adapterFruitCategory



        }








        binding.rvCategoryFruits.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFruits.layoutManager = LinearLayoutManager(context)


        // Inflate the layout for this fragment
        return binding.root
    }


}