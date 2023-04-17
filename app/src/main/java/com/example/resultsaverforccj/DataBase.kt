package com.example.resultsaverforccj

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class DataBase(

    //id(主キー)
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val result: String,
    val character: String,
    val map: String,
    val kill: Int,
    val death: Int,
    val chain: Int,
    val run: Int,
    val score: Int,
    val cpu: Int,
    val goal: Int,
    val charge: Double,
)