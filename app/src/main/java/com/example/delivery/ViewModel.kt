package com.example.delivery

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.delivery.database.FoodDatabase
import com.example.delivery.model.Food
import com.example.delivery.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    val foodRepository: FoodRepository
    var readAllFoods: LiveData<List<Food>>

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()

        foodRepository = FoodRepository(foodDao)
        readAllFoods = foodRepository.readAllFoods
    }
    fun readFood( _id: Int ): LiveData<Food> {
        return foodRepository.readFood(_id)
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
}