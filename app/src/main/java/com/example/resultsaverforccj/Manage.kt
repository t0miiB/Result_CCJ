package com.example.resultsaverforccj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.content.ContentValues
import android.content.Intent
import android.widget.Spinner
import android.widget.CheckBox

class Manage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)
        //ヘルパー準備
        val helper = DataBaseHelper(this)

        val cols = arrayOf("result","usedChara","map","kill","death",
            "charge","chain","runP","score","cpu","goal")
        val params = arrayOf("WIN","LOSE","DRAW")
        helper.readableDatabase.use{ db ->
            db.query("results",cols,"result = ?",
                      params,null,null,null,null
            ).use{cs ->
                if(cs.moveToFirst()){

                }

            }
        }
    }



}