package app.play.me.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.play.me.databinding.ItemTopMixBinding
import app.play.me.model.TopMusic


class  TopMixesAdapter : ListAdapter<TopMusic, TopMixesAdapter.MostPlayedViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<TopMusic>() {
        override fun areItemsTheSame(oldItem:TopMusic, newItem:TopMusic): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:TopMusic, newItem:TopMusic): Boolean {
            return oldItem == newItem
        }
    }

    inner class MostPlayedViewHolder(val binding: ItemTopMixBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPlayedViewHolder {
        return MostPlayedViewHolder(ItemTopMixBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MostPlayedViewHolder, position: Int) {

//        Glide
//            .with(holder.binding.root)
//            .load(currentList[position].image)
//            .into(holder.binding.imageProduct)

    }
}