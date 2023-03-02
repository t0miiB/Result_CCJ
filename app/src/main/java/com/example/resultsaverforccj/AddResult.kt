package com.example.resultsaverforccj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class AddResult : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_result)

        //ヘルパー準備
        val helper = DataBaseHelper(this)
        //DB取得
        helper.writableDatabase.use{
            Toast.makeText(this, "生成しました",
                Toast.LENGTH_LONG).show()
            }


    }
}