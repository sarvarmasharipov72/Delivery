package com.example.delivery.ui.zakaz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.ViewModel
import com.example.delivery.adapter.OrderAdapter

class ZakazFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_zakaz, container, false)
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        var recycler = root.findViewById<RecyclerView>(R.id.recyclerZakaz)
        val adapter = OrderAdapter()
        recycler.adapter = adapter

        viewModel.readAllOrder.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        // Inflate the layout for this fragment
        return root
    }


}