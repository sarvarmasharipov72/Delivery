package com.example.delivery.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.delivery.R
import java.lang.Integer.parseInt


class FragmentOrder : Fragment() {
    private val foodFragmentArgs by navArgs<FragmentOrderArgs>()

    private lateinit var count: TextView
    private lateinit var foodPrice: TextView
    private lateinit var orderButton: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_order, container, false)
        // Inflate the layout for this fragment
        count = root.findViewById(R.id.count)
        foodPrice = root.findViewById<TextView>(R.id.foodPrice).apply {
            text = foodFragmentArgs.parcelable.price.toString()
        }


        orderButton = root.findViewById(R.id.orderButton)
        root.findViewById<TextView>(R.id.nameOrder).apply{
            text = foodFragmentArgs.parcelable.name
        }
        root.findViewById<ImageView>(R.id.imageOrder).apply {
            setImageResource(foodFragmentArgs.parcelable.imgMaxSize)
        }

        root.findViewById<Button>(R.id.add).apply {
            setOnClickListener {
                count.text = ( Integer.parseInt(count.text.toString()) + 1).toString()
                foodPrice.text = (parseInt(foodPrice.text.toString()) + foodFragmentArgs.parcelable.price).toString()

            } }
        root.findViewById<Button>(R.id.minus).apply {
            setOnClickListener {
                if (count.text != "1") {
                    count.text = (parseInt(count.text.toString()) - 1).toString()

                    foodPrice.text =
                        (parseInt(foodPrice.text.toString()) - foodFragmentArgs.parcelable.price).toString()
                }
            } }
        return root
    }


}