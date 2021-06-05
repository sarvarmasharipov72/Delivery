package com.example.delivery.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder

@Dao
interface FoodDao {

    @Insert
    fun addOrder(order: FoodOrder)

    @Query("SELECT * FROM foodOrderTable ORDER BY id DESC")
    fun readAllOrder(): LiveData<List<FoodOrder>>

}