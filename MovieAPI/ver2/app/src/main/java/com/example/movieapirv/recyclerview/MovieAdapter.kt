package com.example.movieapirv.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapirv.R
import com.example.movieapirv.network.result.DailyBoxOfficeList

class MovieAdapter(val context: Context): RecyclerView.Adapter<MovieViewHolder>() {
    var data = listOf<DailyBoxOfficeList>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(data[position])
    }
}