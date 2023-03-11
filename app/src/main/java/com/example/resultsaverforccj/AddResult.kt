package com.example.resultsaverforccj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.content.ContentValues
import android.content.Intent
import android.widget.AdapterView
import android.view.View
import android.widget.Spinner
import android.widget.CheckBox

class AddResult : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_result)

        val helper = DataBaseHelper(this)

        //spinner取得
        val spnResult = findViewById<Spinner>(R.id.SpnResult)
        val spnCharacter = findViewById<Spinner>(R.id.SpnCharacter)
        val spnMap = findViewById<Spinner>(R.id.SpnMap)
        //取得した値を保存する変数
        var itemResult = "WIN"
        var itemCharacter = "カギコ"
        var itemMap = "ウラシブヤ"

        spnResult.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item0 = spinnerParent.selectedItem as String
                itemResult = item0
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }
        spnCharacter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item1 = spinnerParent.selectedItem as String
                itemCharacter = item1
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }
        spnMap.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item2 = spinnerParent.selectedItem as String
                itemMap = item2
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        //checkbox取得
        val cheCpu = findViewById<CheckBox>(R.id.cpu_part)
        val cheGoal = findViewById<CheckBox>(R.id.goal_in)
        //取得した値を保存する変数
        var itemCpu = 0
        var itemGoal = 0
        cheCpu.setOnClickListener{
            itemCpu = if(cheCpu.isChecked){
                1
            }else{
                0
            }
        }
        cheCpu.setOnClickListener{
            itemGoal = if(cheGoal.isChecked){
                1
            }else{
                0
            }
        }

        //中止ボタン押下でメイン画面に戻る
        val btnMain = findViewById<Button>(R.id.back_main)
        btnMain.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        //edittext取得
        val txtKill = findViewById<EditText>(R.id.eT_kill)
        val txtDeath = findViewById<EditText>(R.id.eT_death)
        val txtCharge = findViewById<EditText>(R.id.eT_charge)
        val txtChain = findViewById<EditText>(R.id.eT_chain)
        val txtRunP = findViewById<EditText>(R.id.eT_runP)
        val txtScore = findViewById<EditText>(R.id.eT_score)

        //保存ボタン押下で入力内容確定、メイン画面に戻る
        val btnSave = findViewById<Button>(R.id.save)
        btnSave.setOnClickListener {
            helper.writableDatabase.use{db ->
                val cv = ContentValues().apply{
                    put("kill",txtKill.text.toString())
                    put("death",txtDeath.text.toString())
                    put("charge",txtCharge.text.toString())
                    put("chain",txtChain.text.toString())
                    put("runP",txtRunP.text.toString())
                    put("score",txtScore.text.toString())
                    put("result",itemResult)
                    put("usedChara",itemCharacter)
                    put("map",itemMap)
                    put("cpu",itemCpu)
                    put("goal",itemGoal)
                }
                db.insert("results",null,cv)
                Toast.makeText(this, "登録完了しました。",Toast.LENGTH_SHORT).show()
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        }
    }
}
