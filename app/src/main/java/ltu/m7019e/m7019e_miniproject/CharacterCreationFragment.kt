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

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
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

            Log.i("str", binding.characterCreationStr.text.toString())
            Log.i("dex", binding.characterCreationDex.text.toString())
            Log.i("con", binding.characterCreationCon.text.toString())
            Log.i("int", binding.characterCreationInt.text.toString())
            Log.i("wis", binding.characterCreationWis.text.toString())
            Log.i("cha", binding.characterCreationInt.text.toString())

            Log.i("hp", binding.characterCreationHp.text.toString())
            Log.i("ac", binding.characterCreationAc.text.toString())
            Log.i("initiative", binding.characterCreationInitiative.text.toString())
            Log.i("speed", binding.characterCreationSpeed.text.toString())
        }
    }
}
