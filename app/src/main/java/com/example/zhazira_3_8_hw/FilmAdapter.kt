package com.example.zhazira_3_8_hw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zhazira_3_8_hw.databinding.ItemFilmBinding

class FilmAdapter(val filmList: List<Film>, private val onClick: (film: Film)-> Unit) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(filmList[position])
    }

    override fun getItemCount(): Int = filmList.size

    inner class ViewHolder(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(film: Film) {
            binding.imgFilm.loadImage(film.image)
            binding.tvName.text = film.name
            binding.tvDate.text = film.date
            itemView.setOnClickListener{
                onClick(film)
            }
        }

    }
}