package com.example.delivery.database

import android.content.Context
import android.util.Log
import androidx.room.*
import com.example.delivery.model.FoodOrder

@Database(entities = [FoodOrder::class],version = 1,exportSchema = false)
@TypeConverters(Converter::class)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE_ORDER: FoodDatabase? = null


        fun getDatabaseOrder(context: Context): FoodDatabase {
            val templateINSTANCE = INSTANCE_ORDER
            if (templateINSTANCE != null) {
                return templateINSTANCE
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, FoodDatabase::class.java, "food_order_data")
                        .build()
                Log.d("tag", "operation Secsesful Order")
                INSTANCE_ORDER = instance
                return instance
            }

        }
    }
}
