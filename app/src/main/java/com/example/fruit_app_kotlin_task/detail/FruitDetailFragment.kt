package com.example.fruit_app_kotlin_task.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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

//        binding = FragmentFruitDetailBinding.inflate(layoutInflater)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_fruit_detail,
            container,
            false)

        val application = requireNotNull(activity).application  // todo: what's every line meaning??
        val getFruitDetail = FruitDetailFragmentArgs.fromBundle(requireArguments()).selectedProperty        // getting the data from Navigation Arg
        val viewModelFactory = FruitDetailViewModelFactory(getFruitDetail, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FruitDetailViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the VieWModel
        binding.fruitViewModel = viewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner


        /* Observing the data received from Prev screen */
        viewModel.fruitDetails.observe(viewLifecycleOwner){
            Log.d(TAG, "fetched data: "+it)

            Glide.with(binding.imgFruit)
                .load(it.image)
                .into(binding.imgFruit)



        }

        /* Observing the Cart Qty update */
        viewModel.fruitCartQty.observe(viewLifecycleOwner){
            var price = viewModel.fruitDetails.value?.sellPrice?.toDouble()
            var grandTotal = it* price!!
            var strSubTotalFormatted = String.format("%.2f",grandTotal).toString()
            binding.txtSubtotal.setText( strSubTotalFormatted+ "₹")         // displaying the subTotal amt

            var taxAmt = (viewModel.tax/100)*grandTotal
            var totalAmt = taxAmt + viewModel.deliveryRate + grandTotal;        // displaying the Grand total amt
            var strTotalAmtFormat = String.format("%.2f",totalAmt).toString()
            binding.txtTotal.setText(strTotalAmtFormat+"₹")
        }




        // Inflate the layout for this fragment
        return binding.root
    }

}