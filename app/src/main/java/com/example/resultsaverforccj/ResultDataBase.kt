package com.example.resultsaverforccj

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBase::class],version = 1)
abstract class ResultDataBase : RoomDatabase(){

    abstract fun dao(): Dao

    companion object {

        private var INSTANCE : ResultDataBase? = null
        private val lock = Any()

        fun getInstance(context: Context): ResultDataBase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ResultDataBase::class.java, "Result.db")
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }

    }
}