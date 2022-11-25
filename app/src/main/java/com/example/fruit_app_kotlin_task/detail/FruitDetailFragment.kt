package com.example.fruit_app_kotlin_task.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.fruit_app_kotlin_task.R
import com.example.fruit_app_kotlin_task.databinding.FragmentFruitDetailBinding

class FruitDetailFragment : Fragment() {

private lateinit var binding : FragmentFruitDetailBinding
private lateinit var viewModel : FruitDetailViewModel
private val TAG  ="FruitDetail_d"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFruitDetailBinding.inflate(layoutInflater)
        val application = requireNotNull(activity).application  // todo: what's every line meaning??
        val getFruitDetail = FruitDetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = FruitDetailViewModelFactory(getFruitDetail, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(FruitDetailViewModel::class.java)

        viewModel.fruitDetails.observe(viewLifecycleOwner){
            Log.d(TAG, "fetched data: "+it)

            Glide.with(binding.imgFruit)
                .load(it.image)
                .into(binding.imgFruit)

            binding.txtFruitName.setText(it.name)
            binding.txtFruitDesc.setText(it.description)
            binding.txtFruitPrice.setText(it.sellPrice)
            binding.txtTotalQty.setText(it.totalQty)
            binding.txtFarmerName.setText(it.farmerName)
            binding.txtFarmerCompany.setText(it.farmerCompany)

        }



        // Inflate the layout for this fragment
        return binding.root
    }

}