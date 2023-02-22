package com.example.galeri

import android.annotation.SuppressLint
import android.content.ContentValues

class ResimlerDAO {

    fun ekle(vt: SQLiteDH , resim_url : String){
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("resim_url",resim_url)
        db.insertOrThrow("resimler",null,values)
        db.close()

    }
    @SuppressLint("Range")
    fun okuma(vt: SQLiteDH) : ArrayList<SQLiteDataTablosu>{
        val db = vt.writableDatabase
        val resimlerArrayList = ArrayList<SQLiteDataTablosu>()

        val cursor = db.rawQuery(" SELECT * FROM resimler",null)
        while(cursor.moveToNext()){
            val resim = SQLiteDataTablosu(cursor.getString(cursor.getColumnIndex("resim_url")))

            resimlerArrayList.add(resim)
        }

        return resimlerArrayList

    }
}