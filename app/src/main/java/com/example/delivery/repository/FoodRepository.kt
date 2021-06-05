package com.example.delivery.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.delivery.database.FoodDao
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder

class FoodRepository(private var foodDao: FoodDao) {
    var readAllOrder = foodDao.readAllOrder()
    suspend fun addFoodOrder(order: FoodOrder){
        foodDao.addOrder(order)
    }

}