package com.example.kotlinbasics.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.Colors


class ColorAdapter(private val colorList: List<Colors>):
    RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorSquare: ImageView = itemView.findViewById(R.id.colorSquare)
        val colorNameText: TextView = itemView.findViewById(R.id.colorNameText)
        val colorYearText: TextView = itemView.findViewById(R.id.colorYearText)
        val colorPantoneText: TextView = itemView.findViewById(R.id.colorPantoneText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_color, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colorList[position]
        holder.colorSquare.setBackgroundColor(Color.parseColor(color.color))
        holder.colorNameText.text = color.name
        holder.colorYearText.text = color.year
        holder.colorPantoneText.text = color.pantone_value
    }

    override fun getItemCount() = colorList.size
}