package com.example.resultsaverforccj

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DBNAME, null, VERSION){

    companion object{
        private const val DBNAME = "Result.sqlite"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE results ( " +
                /*
                        カラム"result","usedChara","map",
                        "kill","death","charge","chain",
                        "runP","score","cpu","goal"を生成
                        cpu,goalについて...BOOLEAN型は無いのでINTEGER(0:偽,1:真)を設定
                        */
                "result TEXT,usedChara TEXT,map TEXT," +
                "kill INTEGER,death INTEGER,charge REAL,chain INTEGER," +
                "runP INTEGER,score INTEGER,cpu INTEGER,goal INTEGER)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            it.execSQL("DROP TABLE IF EXISTS results")
            onCreate(it)
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }
}

