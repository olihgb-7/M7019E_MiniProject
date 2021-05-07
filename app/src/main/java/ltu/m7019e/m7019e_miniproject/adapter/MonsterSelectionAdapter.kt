package ltu.m7019e.m7019e_miniproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ltu.m7019e.m7019e_miniproject.databinding.MonsterSelectionItemBinding
import ltu.m7019e.m7019e_miniproject.model.Monster


class MonsterSelectionAdapter : ListAdapter<Monster, MonsterSelectionAdapter.ViewHolder>(MoviewReviewDiffCallback()) {

    class ViewHolder(private var binding: MonsterSelectionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(monster: Monster) {
            binding.monster = monster
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MonsterSelectionItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}

class MoviewReviewDiffCallback : DiffUtil.ItemCallback<Monster>() {
    override fun areItemsTheSame(oldItem: Monster, newItem: Monster): Boolean {
        return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(oldItem: Monster, newItem: Monster): Boolean {
        return oldItem == newItem
    }
}