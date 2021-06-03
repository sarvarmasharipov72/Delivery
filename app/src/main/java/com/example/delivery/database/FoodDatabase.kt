package com.example.delivery.database

import android.content.Context
import android.util.Log
import androidx.room.*
import com.example.delivery.model.Food

@Database(entities = [Food::class],version = 1,exportSchema = false)
@TypeConverters(Converter::class)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object{
    @Volatile
    private var INSTANCE: FoodDatabase?= null

        fun getDatabase(context: Context): FoodDatabase {
            val templateINSTANCE = INSTANCE
            if (templateINSTANCE != null){
                return templateINSTANCE
            }
         synchronized(this){
             val instance = Room.databaseBuilder(context,FoodDatabase::class.java,"food_data")
                 .build()
             Log.d("tag","operation Secsesful")
             INSTANCE = instance
             return instance
         }

        }
    }

}