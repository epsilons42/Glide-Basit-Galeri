package com.example.galeri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_resim_ekle.*


class resimEkle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resim_ekle)

        val vt = SQLiteDH(this)

        buttonEkle.setOnClickListener {
            val url = resimUrlET.text.toString()
            if(url.length > 0){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
                ResimlerDAO().ekle(vt,url)

            }else{
                Toast.makeText(applicationContext,"URL GİRİNİZ", Toast.LENGTH_SHORT).show()
            }
        }

        buttonGoster.setOnClickListener {
            val url = resimUrlET.text.toString()
            Glide.with(this).load(url).into(imageEkle)
        }

    }


}