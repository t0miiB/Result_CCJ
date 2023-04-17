package com.example.resultsaverforccj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.AdapterView
import android.view.View
import android.widget.Spinner
import android.widget.CheckBox

class AddResult : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_result)

        val database = ResultDataBase.getInstance(this)
        val dao = database.dao()

        //spinner
        val spnResult = findViewById<Spinner>(R.id.spnResult)
        val spnCharacter = findViewById<Spinner>(R.id.spnCharacter)
        val spnMap = findViewById<Spinner>(R.id.spnMap)

        //退避用変数
        var result = "WIN"
        var character = "カギコ"
        var map = "ウラシブヤ"

        spnResult.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item0 = spinnerParent.selectedItem as String
                result = item0
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
                character = item1
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
                map = item2
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        //checkbox
        val cheCpu = findViewById<CheckBox>(R.id.cpuPart)
        val cheGoal = findViewById<CheckBox>(R.id.goalIn)

        //退避用変数
        var cpu = 0
        var goal = 0

        cheCpu.setOnClickListener{
            val tempCpu = cheCpu.isChecked
            if(tempCpu){
                cpu = 1
            }else{
                cpu = 0
            }
        }
        cheGoal.setOnClickListener{
            val tempGoal = cheGoal.isChecked
            if(tempGoal){
                goal = 1
            }else{
                goal = 0
            }
        }

        //中止ボタン
        val btnMain = findViewById<Button>(R.id.backMain)
        btnMain.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        //edittext
        val txtKill = findViewById<EditText>(R.id.kill)
        val txtDeath = findViewById<EditText>(R.id.death)
        val txtCharge = findViewById<EditText>(R.id.charge)
        val txtChain = findViewById<EditText>(R.id.chain)
        val txtRun = findViewById<EditText>(R.id.runPoint)
        val txtScore = findViewById<EditText>(R.id.score)

        //退避用変数
        var kill:Int
        var death:Int
        var charge:Double
        var chain:Int
        var run:Int
        var score:Int

        fun editTextToInt(editText: EditText):Int{
            val insertValue:Int
            if(editText == null){
                insertValue = 0
            }else{
                insertValue = editText.text.toString().toInt()
            }
            return insertValue
        }


        //保存ボタン
        val btnSave = findViewById<Button>(R.id.save)
        btnSave.setOnClickListener{
            kill = editTextToInt(txtKill)
            death = editTextToInt(txtDeath)
            chain = editTextToInt(txtChain)
            run = editTextToInt(txtRun)
            score = editTextToInt(txtScore)
            charge = txtCharge.text.toString().toDouble()
            val insertData =
                DataBase(0,result,character,map,kill,death,chain,run,score,cpu,goal,charge)
            dao.insert(insertData)
            Toast.makeText(this, "登録完了しました。",Toast.LENGTH_SHORT).show()
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}
