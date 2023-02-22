package com.example.galeri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.galeri.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_row.*

class MainActivity : AppCompatActivity() {
    private lateinit var vB : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        vB = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(vB.root)

        //Veri Tabanı işlemleri
        val vt = SQLiteDH(this)
        val resimListesi = ResimlerDAO().okuma(vt)
        var indeks = 0
        val alist = ArrayList<String>()
        while(indeks< resimListesi.size){
            alist.add(resimListesi.get(indeks).resim_url)
            indeks ++
        }

        //RecyclerView işlemleri
        val layoutmeneger = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutmeneger
        val adapter = RecyclerAdapter(this,alist)
        recyclerView.adapter = adapter


        //Menu İşlemleri
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ekle_menusu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_ekle ->{
                val intent = Intent(this,resimEkle::class.java)
                startActivity(intent)
                return true
            }else -> return super.onOptionsItemSelected(item)
        }
    }
}