package com.example.delivery.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodOrderTable")
data class FoodOrder( @PrimaryKey(autoGenerate = true) val id: Int = 0
                      ,val name: String
                      ,val price: Int
                      ,val img: Int)