package com.example.delivery.database

import android.content.Context
import android.util.Log
import androidx.room.*
import com.example.delivery.model.Food
import com.example.delivery.model.FoodOrder

@Database(entities = arrayOf(Food::class,FoodOrder::class),version = 1,exportSchema = false)
@TypeConverters(Converter::class)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE_FOOD: FoodDatabase? = null
        private var INSTANCE_ORDER: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            val templateINSTANCE = INSTANCE_FOOD
            if (templateINSTANCE != null) {
                return templateINSTANCE
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, FoodDatabase::class.java, "food_data")
                        .build()
                Log.d("tag", "operation Secsesful")
                INSTANCE_FOOD = instance
                return instance
            }

        }

        fun getDatabaseOrder(context: Context): FoodDatabase {
            val templateINSTANCE = INSTANCE_ORDER
            if (templateINSTANCE != null) {
                return templateINSTANCE
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, FoodDatabase::class.java, "food_order_data")
                        .build()
                Log.d("tag", "operation Secsesful Order")
                INSTANCE_FOOD = instance
                return instance
            }

        }
    }
}
