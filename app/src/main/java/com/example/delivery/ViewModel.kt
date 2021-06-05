package com.example.delivery

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.delivery.database.FoodDatabase
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder
import com.example.delivery.model.getList
import com.example.delivery.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    val foodOrderRepository: FoodRepository
    var readAllFoods: List<Food>
    var readAllOrder: LiveData<List<FoodOrder>>

    init {
        val foodDaoOrder = FoodDatabase.getDatabaseOrder(application).foodDao()

        foodOrderRepository = FoodRepository(foodDaoOrder)
        readAllOrder = foodOrderRepository.readAllOrder
        readAllFoods = getList()
    }
    fun addOrder(order: FoodOrder){
        viewModelScope.launch(Dispatchers.IO) {
            foodOrderRepository.addFoodOrder(order)
        }
    }



}