package com.example.mvvmlearning6_rommdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDAO():ContactDAO

//    STEPS: Create a companion object

//    NOTES: Volatile means that writes to this field are immediately made visible to other threads.

//    Create a function getDatabase and check if that instance is null or not if not null then return the instance else create a new instance and return it
    companion object {

    @Volatile
        private var INSTANCE: ContactDatabase? = null

      fun getDatabase(context:Context):ContactDatabase{

          synchronized(this){
              if(INSTANCE==null){
                  INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"ContactDB").build()
//              return INSTANCE!!;
              }
          }


          return INSTANCE!!;
      }

    }

}