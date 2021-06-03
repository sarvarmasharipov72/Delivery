package com.example.delivery.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.delivery.R


class FragmentOrder : Fragment() {

    private lateinit var count: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_order, container, false)
        // Inflate the layout for this fragment
        count = root.findViewById(R.id.count)
        root.findViewById<Button>(R.id.add).apply {
            setOnClickListener {
                count.text = ( Integer.parseInt(count.text.toString()) + 1).toString()
            } }
        root.findViewById<Button>(R.id.minus).apply {
            setOnClickListener {
                count.text = ( Integer.parseInt(count.text.toString()) - 1).toString()
            } }
        return root
    }


}