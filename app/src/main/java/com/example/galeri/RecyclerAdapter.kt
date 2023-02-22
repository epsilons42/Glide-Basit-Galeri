package com.example.galeri

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_row.view.*


class RecyclerAdapter(val context : Context,val alist : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ResimlerVH>() {
    class ResimlerVH(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResimlerVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ResimlerVH(itemView)
    }


    override fun getItemCount(): Int {
        return alist.size
    }

    override fun onBindViewHolder(holder: ResimlerVH, position: Int ) {
        Glide.with(context).load(alist.get(position)).into(holder.itemView.imageList)
    }
}