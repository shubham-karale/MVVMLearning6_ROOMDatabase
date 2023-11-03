package com.example.mvvmlearning6_rommdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

// Name of the Database Table
@Entity(tableName = "contact")
data class Contact(

//    Primary key is auto generated
    @PrimaryKey(autoGenerate = true)

//    Data class members
    val id: Long,
    val name: String,
    val phone: String
)
