package com.example.fruit_app_kotlin_task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fruit_app_kotlin_task.R

import com.example.fruit_app_kotlin_task.response.Cdata
import com.example.fruit_app_kotlin_task.response.Data

class FruitAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Cdata,FruitAdapter.ViewHolder>(MyDiffUtil) {
    // filter interface ->  , Filterable

    companion object MyDiffUtil : DiffUtil.ItemCallback<Cdata>() {
        /*  used to determine structural changes between old and new list (additions/removals/position changes) */
        override fun areItemsTheSame(oldItem: Cdata, newItem: Cdata): Boolean {
            return oldItem == newItem
        }

        /* determines if particular item was updated */
        override fun areContentsTheSame(oldItem: Cdata, newItem: Cdata): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fruit_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = getItem(position)

        holder.fruitName.setText(fruit.name)
        holder.fruitPrice.setText(fruit.sellPrice)

        Glide.with(holder.itemView.context)
            .load(fruit.image)
            .into(holder.fruitImg)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(fruit)
        }

    }

    class OnClickListener(val clickListener: (fruit: Cdata) -> Unit){
        fun onClick(fruit: Cdata) = clickListener(fruit)
    }



    /* the SearchBar fiter */
//    override fun getFilter(): Filter {
//        return object: Filter(){
//
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charString = constraint?.toString() ?: ""
//                if (!charString.isEmpty()) {
//
//
//                val filteredList = ArrayList<Cdata>()
//                mFruit.filter {
//                    (it.name?.contains(constraint!!) == true)
//                }
//                    .forEach { filteredList.add(it) }
//
//                    mFruit = filteredList
//            }
//                return FilterResults().apply{values = mFruit}
//
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                mFruit = if (results?.values == null)
//                    ArrayList()
//                else
//                    results.values as ArrayList<Cdata>
//                notifyDataSetChanged()
//
//            }
//        }
//    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitName = itemView.findViewById<TextView>(R.id.fruit_txt)
        val fruitImg = itemView.findViewById<ImageView>(R.id.fruit_img)
        val fruitPrice = itemView.findViewById<TextView>(R.id.fruit_price)


        }

    }



