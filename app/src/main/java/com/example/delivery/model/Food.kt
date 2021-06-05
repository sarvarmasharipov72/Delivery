package com.example.delivery.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.delivery.R
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "foodTable")
data class Food( @PrimaryKey(autoGenerate = true) val id: Int = 0
                 , val name: String
                 , val price: Int
                 , val imgMinSize: Int) : Parcelable
fun getList(): List<Food>{
    return listOf(
            Food(name = "Shaverma", price = 15000, imgMinSize = R.drawable.shaverma),
            Food(name = "Somsa", price = 8000, imgMinSize = R.drawable.somsa),
            Food(name = "Lavash", price = 18000, imgMinSize = R.drawable.lavash),
            Food(name = "KFS", price = 25000, imgMinSize = R.drawable.kfs),
            Food(name = "Gamburger", price = 14000, imgMinSize = R.drawable.gamburger),
            Food(name = "Grill", price = 30000, imgMinSize = R.drawable.grill),
            Food(name = "Setka tovuq", price = 55000, imgMinSize = R.drawable.setka_tovuq),
            Food(name = "Kabob", price = 16000, imgMinSize = R.drawable.kabob),
            Food(name = "Setka kabob", price = 45000, imgMinSize = R.drawable.setka_kabob),
            Food(name = "Shashlik", price = 8000, imgMinSize = R.drawable.shashlik),
            Food(name = "Pitsa", price = 42000, imgMinSize = R.drawable.pitsa),
            Food(name = "Chizburger", price = 16000, imgMinSize = R.drawable.chizburger),
            Food(name = "Chickenburger", price = 17000, imgMinSize = R.drawable.chickenburger),
            Food(name = "Bifshteks", price = 13000, imgMinSize = R.drawable.bifshteks),
            Food(name = "Beshbarmoq", price = 32000, imgMinSize = R.drawable.beshmarmoq),
            Food(name = "Go'sht say", price = 60000, imgMinSize = R.drawable.gosht_say),
            Food(name = "Hot Dog", price = 12000, imgMinSize = R.drawable.hotdog),
            Food(name = "Norin", price = 25000, imgMinSize = R.drawable.norin),
            Food(name = "Qozon kabob", price = 48000, imgMinSize = R.drawable.qozon_kabob),
            Food(name = "Steyk", price = 60000, imgMinSize = R.drawable.steyk)
    )
}