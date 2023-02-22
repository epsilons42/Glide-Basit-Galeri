package com.example.galeri

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class SQLiteDH(context : Context) : SQLiteOpenHelper(context,"Resimler",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(" CREATE TABLE resimler (resim_url TEXT PRİMARY KEY);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE İF EXİSTS resimler")
        onCreate(db)
    }
}