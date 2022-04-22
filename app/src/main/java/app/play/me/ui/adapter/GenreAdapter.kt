package app.play.me.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.play.me.databinding.ItemGenreBinding
import app.play.me.model.Genre
import com.bumptech.glide.Glide
import timber.log.Timber
import java.lang.Exception
import java.util.*


class  GenreAdapter : ListAdapter<Genre, GenreAdapter.GenreAdapterViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem:Genre, newItem:Genre): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:Genre, newItem:Genre): Boolean {
            return oldItem == newItem
        }
    }

    inner class GenreAdapterViewHolder( val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapterViewHolder {
        return GenreAdapterViewHolder(ItemGenreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreAdapterViewHolder, position: Int) {

        try {
            val color = Color.parseColor(getItem(position).color)
            holder.binding.materialCard.setCardBackgroundColor(color)
        } catch (e: Exception) {
            println("BUG ${getItem(position).title}")
            Timber.d(e.toString())
        }
        holder.binding.tvTitle.text = getItem(position).title
        Glide
            .with(holder.binding.root)
            .load(getItem(position).cover)
            .into(holder.binding.imgCover)

    }
}