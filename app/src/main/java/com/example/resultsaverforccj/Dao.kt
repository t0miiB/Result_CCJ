package com.example.resultsaverforccj

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    //@Query("SELECT * FROM user")
    //fun getALL(): List<DataBase>

    @Insert
    fun insert(user: DataBase)

    @Update
    fun update(user: DataBase)

    @Delete
    fun delete(user: DataBase)
}