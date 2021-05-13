package ltu.m7019e.m7019e_miniproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ltu.m7019e.m7019e_miniproject.databinding.CharacterSelectionItemBinding
import ltu.m7019e.m7019e_miniproject.model.Character

class CharacterSelectionAdapter(private val characterClickListener: CharacterClickListener): ListAdapter<Character, CharacterSelectionAdapter.ViewHolder>(CharacterSelectionDiffCallback()) {

    class ViewHolder(private var binding: CharacterSelectionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character, characterClickListener: CharacterClickListener) {
            binding.character = character
            binding.clickListener = characterClickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CharacterSelectionItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position), characterClickListener)
    }
}

class CharacterSelectionDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}

class CharacterClickListener(val clickListener: (character: Character) -> Unit) {
    fun onClick(character: Character) = clickListener(character)
}