package com.example.delivery.ui.kafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.ViewModel
import com.example.delivery.adapter.FoodRecyclerAdapter
import com.example.delivery.model.Food
import com.example.delivery.model.getList
import java.util.*

class KafeList : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_kafe_list, container, false)
        val foodViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val list = getList()
        var list1 = listOf(
            list[random(list.size-1)],
            list[random(list.size-1)],
            list[random(list.size-1)],
            list[random(list.size-1)],
            list[random(list.size-1)],
            list[random(list.size-1)]
        )
        val adapter = FoodRecyclerAdapter(list1)
        val recycler = root.findViewById<RecyclerView>(R.id.recyclerHomeList)
        recycler.adapter = adapter
        return root
    }
    fun random( x: Int): Int{
        return Random().nextInt(x)
    }

}