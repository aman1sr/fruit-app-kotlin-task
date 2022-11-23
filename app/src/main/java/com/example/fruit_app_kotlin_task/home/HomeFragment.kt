package com.example.fruit_app_kotlin_task.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruit_app_kotlin_task.R
import com.example.fruit_app_kotlin_task.adapter.FruitAdapter
import com.example.fruit_app_kotlin_task.adapter.FruitsCategoryAdapter
import com.example.fruit_app_kotlin_task.databinding.FragmentHomeBinding

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


        /* Updating Fruit List wrt Click on Fruit Cat */
        viewModel.subFruitList.observe(viewLifecycleOwner) { fruitList ->
//            adapterFruit = FruitAdapter(fruitList)
            adapterFruit.submitList(fruitList)
            binding.rvFruits.adapter = adapterFruit
        }


        viewModel.detailFruit.observe(viewLifecycleOwner, Observer {

            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFruitDetailFragment(it!!))
            // article ?. vs !!  (https://blog.mindorks.com/safecalls-vs-nullchecks-in-kotlin)

        })

        /* OnClick Listener on Specific Fruit  */
        adapterFruit = FruitAdapter(FruitAdapter.OnClickListener {
            Log.d(TAG, "Fruit clickedddddddddd>>> ")
            viewModel.getDetailFruit(it)
        })


        /* OnClick Listener on Fruit Category */
        adapterFruitCategory = FruitsCategoryAdapter(FruitsCategoryAdapter.OnClickListener {
            Log.d(TAG, "clickedddddddddd>>> ")
            var fruitList = it      // if could extract it out of ViewModel,  => if
            viewModel.getSubFruitList(fruitList)

        })





        binding.searchBar.setOnQueryTextListener(this)

        binding.rvCategoryFruits.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFruits.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    // todo: check this codeLab Article (concept of DiffUtils) -> https://developer.android.com/codelabs/kotlin-android-training-diffutil-databinding?index=..%2F..android-kotlin-fundamentals#0
    override fun onQueryTextSubmit(query: String?): Boolean {
//        adapterFruit.filter.filter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
//        adapterFruit.filter.filter(newText)
        return false
    }


}