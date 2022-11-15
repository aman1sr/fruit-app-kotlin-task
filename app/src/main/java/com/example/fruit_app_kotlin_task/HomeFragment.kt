package com.example.fruit_app_kotlin_task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruit_app_kotlin_task.adapter.FruitAdapter
import com.example.fruit_app_kotlin_task.adapter.FruitsCategoryAdapter
import com.example.fruit_app_kotlin_task.databinding.FragmentHomeBinding

import com.example.fruit_app_kotlin_task.response.Cdata
import com.example.fruit_app_kotlin_task.response.FruitModel

class HomeFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private val TAG = "Home_d"


    private lateinit var adapterFruitCategory: FruitsCategoryAdapter
    private lateinit var adapterFruit: FruitAdapter

    var fruitListCat: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

//         todo: track the progesss, (horizontal PB , 1-100% )
        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        /* Fetching the Initial Fruit Category data */
        viewModel.fruitList.observe(viewLifecycleOwner) {

            val fruitList: FruitModel = it

            adapterFruitCategory.submitList(fruitList?.data)
            binding.rvCategoryFruits.adapter = adapterFruitCategory

        }


                    /* OnClick Listener */
        adapterFruitCategory = FruitsCategoryAdapter(FruitsCategoryAdapter.OnClickListener {
            Log.d(TAG, "clickedddddddddd>>> ")

            /* todo:  make this stuff below LIVE DATA , to remain rotation safe */
            var fruitList = it      // if could extract it out of ViewModel,  => if
            viewModel.getSubFruitList(fruitList)

        })


        viewModel.subFruitList.observe(viewLifecycleOwner){ fruitList ->
            adapterFruit = FruitAdapter(fruitList)
            binding.rvFruits.adapter = adapterFruit
        }



        binding.searchBar.setOnQueryTextListener(this)


        binding.rvCategoryFruits.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFruits.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
//        adapterFruit.filter.filter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
//        adapterFruit.filter.filter(newText)
        return false
    }


}