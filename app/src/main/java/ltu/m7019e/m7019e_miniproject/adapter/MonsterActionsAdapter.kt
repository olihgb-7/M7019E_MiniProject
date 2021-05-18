package ltu.m7019e.m7019e_miniproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ltu.m7019e.m7019e_miniproject.databinding.MonsterActionsItemBinding
import ltu.m7019e.m7019e_miniproject.network.MonsterAction

class MonsterActionsAdapter: ListAdapter<MonsterAction, MonsterActionsAdapter.ViewHolder>(MonsterActionsDiffCallback()) {

    class ViewHolder(private var binding: MonsterActionsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(monsterAction: MonsterAction) {
            binding.monsterAction = monsterAction
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MonsterActionsItemBinding.inflate(layoutInflater, parent, false)
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

class MonsterActionsDiffCallback : DiffUtil.ItemCallback<MonsterAction>() {
    override fun areItemsTheSame(oldItem: MonsterAction, newItem: MonsterAction): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MonsterAction, newItem: MonsterAction): Boolean {
        return oldItem == newItem
    }
}