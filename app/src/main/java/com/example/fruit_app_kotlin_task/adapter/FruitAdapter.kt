package com.example.fruit_app_kotlin_task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fruit_app_kotlin_task.R
import com.example.fruit_app_kotlin_task.model.Fruits
import com.example.fruit_app_kotlin_task.model.FruitsCategory
import com.example.fruit_app_kotlin_task.response.Cdata

class FruitAdapter(private val mFruit:ArrayList<Cdata> ) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    var onItemClick : ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fruit_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = mFruit.get(position)

        holder.fruitName.setText(fruit.name)
        holder.fruitPrice.setText(fruit.sellPrice)

        Glide.with(holder.itemView.context)
            .load(mFruit.get(position).image)
            .into(holder.fruitImg)

    }

    override fun getItemCount(): Int {
        return mFruit.size
    }


   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitName = itemView.findViewById<TextView>(R.id.fruit_txt)
        val fruitImg = itemView.findViewById<ImageView>(R.id.fruit_img)
        val fruitPrice = itemView.findViewById<TextView>(R.id.fruit_price)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }

    }

}