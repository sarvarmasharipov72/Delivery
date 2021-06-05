package com.example.delivery.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder

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

    @Insert
    fun addOrder(order: FoodOrder)

    @Query("SELECT * FROM foodOrderTable ORDER BY id DESC")
    fun readAllOrder(): LiveData<List<FoodOrder>>

}