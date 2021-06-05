package com.example.delivery

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.delivery.database.FoodDatabase
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder
import com.example.delivery.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    val foodRepository: FoodRepository
    val foodOrderRepository: FoodRepository
    var readAllFoods: LiveData<List<Food>>
    var readAllOrder: LiveData<List<FoodOrder>>

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()
        val foodDaoOrder = FoodDatabase.getDatabaseOrder(application).foodDao()

        foodRepository = FoodRepository(foodDao)
        foodOrderRepository = FoodRepository(foodDaoOrder)
        readAllOrder = foodOrderRepository.readAllOrder
        readAllFoods = foodRepository.readAllFoods
    }
    fun addAllFoods(foods: List<Food>){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.addAllFoods(foods)
        }
    }
    fun addFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.addFood(food)
        }
    }
    fun addOrder(order: FoodOrder){
        viewModelScope.launch(Dispatchers.IO) {
            foodOrderRepository.addFoodOrder(order)
        }
    }



}