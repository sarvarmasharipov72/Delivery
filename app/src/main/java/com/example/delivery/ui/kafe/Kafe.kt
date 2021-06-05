package com.example.delivery.ui.kafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.adapter.FoodRecyclerAdapter
import com.example.delivery.adapter.KafeRecyclerAdapter
import com.example.delivery.model.Food


class Kafe : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_kafe, container, false)
        val viewModel: List<Food> = getListKafe()
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerKafe)
        val adapter = KafeRecyclerAdapter(viewModel)
        recyclerView.adapter = adapter
        // Inflate the layout for this fragment
        return root
    }

    fun getListKafe(): List<Food> {
        return listOf(
            Food(name = "Melnitsa", price = 10, imgMinSize = R.drawable.melnitsa),
            Food(name = "Sharshara", price = 7, imgMinSize = R.drawable.sharshara),
            Food(name = "Mir Kafe", price = 7, imgMinSize = R.drawable.mir_kafe),
            Food(name = "Qamish Burger", price = 8, imgMinSize = R.drawable.qamish),
            Food(name = "Gavhar", price = 10, imgMinSize = R.drawable.gavhar),
            Food(name = "Billur Kafe", price = 7, imgMinSize = R.drawable.billur_kafe),
            Food(name = "Taj Kafe", price = 6, imgMinSize = R.drawable.taj_kafe),
            Food(name = "Monro Kafe", price = 7, imgMinSize = R.drawable.monro_kafe),
            Food(name = "Garaj Burger", price = 7, imgMinSize = R.drawable.garage_burger)
        )
    }
}