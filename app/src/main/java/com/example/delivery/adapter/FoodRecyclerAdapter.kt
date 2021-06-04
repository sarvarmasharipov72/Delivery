package com.example.delivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.model.Food
import com.example.delivery.ui.home.HomeFragmentDirections

class FoodRecyclerAdapter: RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {
    class FoodViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgCart = view.findViewById<ImageView>(R.id.imgCart)
        val foodCartName = view.findViewById<TextView>(R.id.foodCartName)
        val foodCartPrice = view.findViewById<TextView>(R.id.foodCartPrice)
        val container = view.findViewById<ConstraintLayout>(R.id.list_itemHome)
        fun bind(food: Food) {
            foodCartName.text = food.name
            foodCartPrice.text = food.price.toString()
            imgCart.setImageResource(food.imgMinSize)
        }
    }
    var list = emptyList<Food>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_cart,parent,false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(list[position])
        holder.container.setOnClickListener {
            val action = HomeFragmentDirections.actionNavHomeToFragmentOrder(list[position])
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Food>){
        this.list = list
        notifyDataSetChanged()

    }
}