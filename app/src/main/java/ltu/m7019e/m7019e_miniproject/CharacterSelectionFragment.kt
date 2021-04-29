package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ltu.m7019e.m7019e_miniproject.database.Characters
import ltu.m7019e.m7019e_miniproject.databinding.CharacterSelectionItemBinding
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterSelectionBinding


class CharacterSelectionFragment : Fragment() {

    private var _binding: FragmentCharacterSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterSelectionBinding.inflate(inflater)



        val characters = Characters()

        characters.list.forEach { character ->
            val characterSelectionItemBinding: CharacterSelectionItemBinding =
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.character_selection_item,
                    container,
                    false
                )
            characterSelectionItemBinding.character = character
            binding.characterSelectionLl.addView(characterSelectionItemBinding.root)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity?
        activity?.showUpButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                (activity as MainActivity?)!!.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}