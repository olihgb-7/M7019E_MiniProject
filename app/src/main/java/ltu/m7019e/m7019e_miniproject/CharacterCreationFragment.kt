package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterCreationBinding
import ltu.m7019e.m7019e_miniproject.utils.SpinnerActivity

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CharacterCreationFragment : Fragment() {

    private var _binding: FragmentCharacterCreationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterCreationBinding.inflate(inflater)

        val classSpinner: Spinner = binding.characterCreationClass
        classSpinner.onItemSelectedListener = SpinnerActivity()

        val raceSpinner: Spinner = binding.characterCreationRace
        raceSpinner.onItemSelectedListener = SpinnerActivity()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterCreationCancel.setOnClickListener {
            findNavController().navigate(CharacterCreationFragmentDirections.actionCharacterCreationFragmentToHomepageFragment())
        }

        binding.characterCreationCreate.setOnClickListener {

        }
    }
}
