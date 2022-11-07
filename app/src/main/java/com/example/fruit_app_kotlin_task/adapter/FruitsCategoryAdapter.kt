package com.example.fruit_app_kotlin_task.adapter

import android.text.Layout
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
import com.example.fruit_app_kotlin_task.model.Fruits
import com.example.fruit_app_kotlin_task.model.FruitsCategory
import com.example.fruit_app_kotlin_task.response.FruitModel

class FruitsCategoryAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<FruitModel, FruitsCategoryAdapter.ViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<FruitModel>() {
        /*  used to determine structural changes between old and new list (additions/removals/position changes) */
        override fun areItemsTheSame(oldItem: FruitModel, newItem: FruitModel): Boolean {
            return oldItem == newItem
        }

        /* determines if particular item was updated */
        override fun areContentsTheSame(oldItem: FruitModel, newItem: FruitModel): Boolean {
            return oldItem.data == newItem.data
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

        holder.itemView.setOnClickListener {
            onClickListener.onClick(fruit)
        }

        holder.bind(fruit)
    }


    class OnClickListener(val clickListener: (fruit: FruitModel) -> Unit) {
        fun onClick(fruit: FruitModel) = clickListener(fruit)
    }


    inner class ViewHolder(private val binding: FruitsCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fruit: FruitModel) {

            binding.fruitCategoryTxt.text = fruit?.data?.get(adapterPosition)?.category

            Glide.with(binding.fruitCategoryImg)
                .load(fruit?.data?.get(adapterPosition)?.cImg)
                .into(binding.fruitCategoryImg)
        }

    }

}