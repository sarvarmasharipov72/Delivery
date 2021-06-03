package com.example.delivery.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodTable")
data class Food( @PrimaryKey(autoGenerate = true) val id: Int = 0
                 , val name: String
                 , val price: Int
                 , val imgMinSize: Int
                 , val imgMaxSize: Int)