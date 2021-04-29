package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterDetailBinding
import ltu.m7019e.m7019e_miniproject.model.Character


class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var character: Character

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterDetailBinding.inflate(inflater)

        character = CharacterDetailFragmentArgs.fromBundle(requireArguments()).character
        binding.character = character

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterDetailBack.setOnClickListener {
            findNavController().navigate(CharacterDetailFragmentDirections.actionCharacterDetailFragmentToCharacterSelectionFragment())
        }
    }
}