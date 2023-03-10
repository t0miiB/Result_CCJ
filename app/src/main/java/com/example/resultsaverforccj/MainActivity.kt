package com.example.resultsaverforccj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ヘルパー準備
        val helper = DataBaseHelper(this)
        //DB取得
        helper.writableDatabase.use{
            Toast.makeText(this, "記録用のデータベースを生成しました。",
                Toast.LENGTH_LONG).show()
        }



        //画面遷移関連
        val addR = findViewById<Button>(R.id.AddResult)
        addR.setOnClickListener {
            val i = Intent(this,AddResult::class.java)
            startActivity(i)
        }
        val sta = findViewById<Button>(R.id.Stats)
        sta.setOnClickListener {
            val i = Intent(this, Stats::class.java)
            startActivity(i)
        }
        val man = findViewById<Button>(R.id.Manage)
        man.setOnClickListener {
            val i = Intent(this, Manage::class.java)
            startActivity(i)
        }
        //val opt = findViewById<Button>(R.id.Option)
        //opt.setOnClickListener {
        //    val i = Intent(this, Option::class.java)
        //    startActivity(i)


        }



    }


