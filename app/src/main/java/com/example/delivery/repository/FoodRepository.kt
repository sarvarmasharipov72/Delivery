package com.example.delivery.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.delivery.database.FoodDao
import com.example.delivery.model.Food

class FoodRepository(private var foodDao: FoodDao) {
    var readAllFoods = foodDao.readAllFoods()
    fun readFood( _id: Int): LiveData<Food> {
        return foodDao.readFood(_id)
    }
    suspend fun addAllFoods(foods: List<Food>){
        foodDao.addAllFoods(foods)
    }
    suspend fun addFood( food: Food){
        foodDao.addFood(food)
    }
}