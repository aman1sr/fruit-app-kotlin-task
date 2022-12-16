package com.example.fruit_app_kotlin_task.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding = FragmentFruitDetailBinding.inflate(layoutInflater)
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

            binding.txtFruitName.setText(it.name)
            binding.txtFruitDesc.setText(it.description)
            binding.txtTotalQty.setText(it.totalQty +"Qty")
            binding.txtFarmerName.setText(it.farmerName)
            binding.txtFarmerCompany.setText(it.farmerCompany)


            /* bottom UI */
            binding.txtFruitPrice.setText("Price: "+it.sellPrice+" ₹")      // setting the price of product
            var price = it.sellPrice?.toDouble()
            viewModel.sellPrice = price!!
        }

        /* Observing the Cart Qty update */
        viewModel.fruitCartQty.observe(viewLifecycleOwner){
            var price = viewModel.sellPrice
            var grandTotal = it*price
//            binding.txtGrandTotalPrice.setText(grandTotal.toString() + "₹")
            var strSubTotalFormatted = String.format("%.2f",grandTotal).toString()
            binding.txtSubtotal.setText( strSubTotalFormatted+ "₹")         // displaying the subTotal amt
            binding.etQtyUpdate.setText(it.toInt().toString())

            var taxAmt = (viewModel.tax/100)*grandTotal
            var totalAmt = taxAmt + viewModel.deliveryRate + grandTotal;        // displaying the Grand total amt
            var strTotalAmtFormat = String.format("%.2f",totalAmt).toString()
            binding.txtTotal.setText(strTotalAmtFormat+"₹")
        }

/*      // Using Data Binding instead

        binding.btnImgPlusQty.setOnClickListener {
            viewModel.addQty()
        }
        binding.btnImgMinusQty.setOnClickListener {
            viewModel.minusQty()
        }
*/


        // Inflate the layout for this fragment
        return binding.root
    }

}