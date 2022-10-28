package com.example.fruit_app_kotlin_task.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruit_app_kotlin_task.R
import com.example.fruit_app_kotlin_task.model.FruitsCategory

class FruitsCategoryAdapter(private val mFruits: List<FruitsCategory>) : RecyclerView.Adapter<FruitsCategoryAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fruits_category_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val fruit: FruitsCategory = mFruits.get(position)

        viewHolder.txtFruitCategory.setText(fruit.fruitName)

    }

    override fun getItemCount(): Int {
       return mFruits.size
    }



    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgFruitCategory = itemView.findViewById<ImageView>(R.id.fruit_category_img)
        val txtFruitCategory = itemView.findViewById<TextView>(R.id.fruit_category_txt)

    }


}