package com.example.delivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.model.FoodOrder

class OrderAdapter: RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    class OrderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(order: FoodOrder) {

        }

    }
    private var listOrder: List<FoodOrder> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_iteam_order,parent,false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(listOrder[position])
    }

    override fun getItemCount(): Int = listOrder.size
}