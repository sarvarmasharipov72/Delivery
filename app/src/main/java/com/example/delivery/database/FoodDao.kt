package com.example.delivery.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.delivery.model.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM foodTable")
    fun readAllFoods(): LiveData<List<Food>>


    @Query("SELECT * FROM foodTable WHERE id = :id")
    fun readFood( id: Int ): LiveData<Food>


    @Insert
    fun addAllFoods( foods: List<Food> )

    @Insert
    fun addFood( foods: Food )

}