package app.play.me.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.play.me.databinding.ItemMostPlayedBinding
import app.play.me.model.TopMusic


class  MostPlayedAdapter : ListAdapter<TopMusic, MostPlayedAdapter.MostPlayedViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<TopMusic>() {
        override fun areItemsTheSame(oldItem:TopMusic, newItem:TopMusic): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:TopMusic, newItem:TopMusic): Boolean {
            return oldItem == newItem
        }
    }

    inner class MostPlayedViewHolder(val binding: ItemMostPlayedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPlayedViewHolder {
        return MostPlayedViewHolder(ItemMostPlayedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MostPlayedViewHolder, position: Int) {
        holder.binding.tvTitle.text = currentList[position].title
        if (currentList[position].isCurrent) {
            holder.binding.lottiePlayIndicator.visibility = View.VISIBLE
        } else {
            holder.binding.lottiePlayIndicator.visibility = View.GONE
        }
//        Glide
//            .with(holder.binding.root)
//            .load(currentList[position].image)
//            .into(holder.binding.imageProduct)

    }
}