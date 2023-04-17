package com.example.resultsaverforccj

import androidx.appcompat.app.AppCompatActivity
import android.content.ContentValues
import android.os.Bundle
import android.widget.ListView


class Manage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        val database = ResultDataBase.getInstance(this)
        val dao = database.dao()
        //val list = dao.getALL()
    }
}


