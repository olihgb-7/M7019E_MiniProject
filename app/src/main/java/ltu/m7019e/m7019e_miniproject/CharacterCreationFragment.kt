package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterCreationBinding

class CharacterCreationFragment : Fragment() {

    private var _binding: FragmentCharacterCreationBinding? = null
    private val binding get() = _binding!!

    private var classSpinner: Spinner? = null
    private var raceSpinner: Spinner? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterCreationBinding.inflate(inflater)

        classSpinner = binding.characterCreationClass
        raceSpinner = binding.characterCreationRace

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterCreationCancel.setOnClickListener {
            findNavController().navigate(CharacterCreationFragmentDirections.actionCharacterCreationFragmentToHomepageFragment())
        }

        binding.characterCreationCreate.setOnClickListener {
            Log.i("name", binding.characterCreationName.text.toString())
            Log.i("race", raceSpinner?.selectedItem.toString())
            Log.i("class", classSpinner?.selectedItem.toString())

            Log.i("str", binding.characterCreationStrength.text.toString())
            Log.i("dex", binding.characterCreationDexterity.text.toString())
            Log.i("con", binding.characterCreationConstitution.text.toString())
            Log.i("int", binding.characterCreationIntelligence.text.toString())
            Log.i("wis", binding.characterCreationWisdom.text.toString())
            Log.i("cha", binding.characterCreationCharisma.text.toString())

            Log.i("hp", binding.characterCreationHealthPoints.text.toString())
            Log.i("ac", binding.characterCreationArmourClass.text.toString())
            Log.i("initiative", binding.characterCreationInitiative.text.toString())
            Log.i("speed", binding.characterCreationSpeed.text.toString())


        }
    }
}
