package com.example.fruit_app_kotlin_task.adapter

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fruit_app_kotlin_task.R
import com.example.fruit_app_kotlin_task.databinding.FruitsCategoryItemBinding

import com.example.fruit_app_kotlin_task.response.Cdata
import com.example.fruit_app_kotlin_task.response.Data
import com.example.fruit_app_kotlin_task.response.FruitModel

class FruitsCategoryAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Data, FruitsCategoryAdapter.ViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<Data>() {
        /*  used to determine structural changes between old and new list (additions/removals/position changes) */
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        /* determines if particular item was updated */
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.category == newItem.category
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FruitsCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val fruit = getItem(position)       // todo: check this
        Log.d("checkAdapter", "onBindViewHolder: "+position+", fruit: "+fruit)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(fruit.cdata)            // sending data to click listener
        }
        holder.bind(fruit)
    }



// todo: how's working the flow
    class OnClickListener(val clickListener: (fruit: ArrayList<Cdata>) -> Unit) {
        fun onClick(fruit: ArrayList<Cdata>) = clickListener(fruit)
    }


    inner class ViewHolder(private val binding: FruitsCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fruit: Data) {

            binding.fruitCategoryTxt.text = fruit?.category

            Glide.with(binding.fruitCategoryImg)
                .load(fruit?.cImg)
                .into(binding.fruitCategoryImg)
        }

    }

}