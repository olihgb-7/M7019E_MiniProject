package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentHomepageBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomepageFragment : Fragment() {

    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageBinding.inflate(inflater)

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
    }

    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity?
        activity?.hideUpButton()
    }
}