package com.example.gb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VpAdapter (val context: Context, val list: ArrayList<guide>): RecyclerView.Adapter<VpAdapter.MyWH>() {
    class MyWH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView2)
        val descr: TextView = itemView.findViewById(R.id.textView2)
        val titele: TextView = itemView.findViewById(R.id.title1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWH {
        val root = LayoutInflater.from(context).inflate(R.layout.vp_adapter,parent, false)
        return MyWH(root)
    }

    override fun onBindViewHolder(holder: MyWH, position: Int) {
        holder.titele.text = list[position].title
        holder.descr.text = list[position].descr
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}