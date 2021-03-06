package ltu.m7019e.m7019e_miniproject

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageBinding.inflate(inflater)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterCreateButton.setOnClickListener {
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToCharacterCreationFragment())
        }

        binding.characterSelectionButton.setOnClickListener {
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToCharacterSelectionFragment())
        }

        binding.monsterSelectionButton.setOnClickListener {
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToMonsterSelectionFragment())
        }

        binding.playersHandbookButton.setOnClickListener {
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToPlayersHandbookFragment())
        }
    }
}