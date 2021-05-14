package ltu.m7019e.m7019e_miniproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ltu.m7019e.m7019e_miniproject.databinding.MonsterSelectionItemBinding
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.model.Monster

class MonsterSelectionAdapter(private val monsterClickListener: MonsterClickListener) : ListAdapter<Monster, MonsterSelectionAdapter.ViewHolder>(MonsterSelectionDiffCallback()) {

    class ViewHolder(private var binding: MonsterSelectionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(monster: Monster, monsterClickListener: MonsterClickListener) {
            binding.monster = monster
            binding.clickListener = monsterClickListener
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
        return holder.bind(getItem(position), monsterClickListener)
    }
}

class MonsterSelectionDiffCallback : DiffUtil.ItemCallback<Monster>() {
    override fun areItemsTheSame(oldItem: Monster, newItem: Monster): Boolean {
        return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(oldItem: Monster, newItem: Monster): Boolean {
        return oldItem == newItem
    }
}

class MonsterClickListener(val clickListener: (monster: Monster) -> Unit) {
    fun onClick(monster: Monster) = clickListener(monster)
}