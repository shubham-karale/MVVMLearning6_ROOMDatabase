package com.example.mvvmlearning6_rommdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var contactDatabase: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactDatabase = ContactDatabase.getDatabase(this)
//        Initializing the database


//        Create Coroutine Scope
        GlobalScope.launch {
//            Inserting the data into the database
            contactDatabase.contactDAO().insertContact(Contact(0,"Rahul","1234567890"))
        }

//        What is Type Converters?
//        



    }

    fun getData(view:View)
    {
        contactDatabase.contactDAO().getContact().observe(this, {

            Log.d("TAG", "getData: ${it[0].name}")

        })
    }
}