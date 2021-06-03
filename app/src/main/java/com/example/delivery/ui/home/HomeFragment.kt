package com.example.delivery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlin.Number
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.ViewModel
import com.example.delivery.adapter.FoodRecyclerAdapter
import java.lang.Integer.parseInt

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recyclerHome)
        val foodViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val foodAdapter = FoodRecyclerAdapter()
        recycler.adapter = foodAdapter
        foodViewModel.readAllFoods.observe(viewLifecycleOwner, Observer {
            foodAdapter.setData(it)
        })
        root.findViewById<ConstraintLayout>(R.id.id).apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_fragmentOrder)
            }
        }


        return root
    }
}