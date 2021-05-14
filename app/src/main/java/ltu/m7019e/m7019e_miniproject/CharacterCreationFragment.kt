package ltu.m7019e.m7019e_miniproject

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabase
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterCreationBinding
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.viewmodel.CharacterCreationViewModel

class CharacterCreationFragment : Fragment() {

    private var _binding: FragmentCharacterCreationBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterCreationViewModel
    private lateinit var viewModelFactory: CharacterCreationViewModel.Factory

    private lateinit var characterDatabaseDao: CharacterDatabaseDao

    private var raceSpinner: Spinner? = null
    private var classSpinner: Spinner? = null


    private lateinit var imgUri: Uri
    private var imgUriString: String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterCreationBinding.inflate(inflater)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        raceSpinner = binding.characterCreationRace
        classSpinner = binding.characterCreationClass

        val application = requireNotNull(this.activity).application
        characterDatabaseDao = CharacterDatabase.getInstance(application).characterDatabaseDao

        viewModelFactory = CharacterCreationViewModel.Factory(characterDatabaseDao, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterCreationViewModel::class.java)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterCreationCancel.setOnClickListener {
            findNavController().navigate(CharacterCreationFragmentDirections.actionCharacterCreationFragmentToHomepageFragment())
        }

        binding.characterCreationCreate.setOnClickListener {
            try {
                val name = binding.characterCreationName.text.toString()
                val race = raceSpinner?.selectedItem.toString()
                val dndClass = classSpinner?.selectedItem.toString()
                val strength = binding.characterCreationStrength.text.toString().toInt()
                val dexterity = binding.characterCreationDexterity.text.toString().toInt()
                val constitution = binding.characterCreationConstitution.text.toString().toInt()
                val intelligence = binding.characterCreationIntelligence.text.toString().toInt()
                val wisdom = binding.characterCreationWisdom.text.toString().toInt()
                val charisma = binding.characterCreationCharisma.text.toString().toInt()
                val healthPoints = binding.characterCreationHealthPoints.text.toString().toInt()
                val armourClass = binding.characterCreationArmourClass.text.toString().toInt()
                val initiative = binding.characterCreationInitiative.text.toString().toInt()
                val speed = binding.characterCreationSpeed.text.toString().toInt()

                var character: Character = Character(
                        name = name,
                        img_uri = imgUriString,
                        race = race,
                        dndClass = dndClass,
                        strength = strength,
                        dexterity = dexterity,
                        constitution = constitution,
                        intelligence = intelligence,
                        wisdom = wisdom,
                        charisma = charisma,
                        healthPoints = healthPoints,
                        armourClass = armourClass,
                        initiative = initiative,
                        speed = speed
                )

                viewModel.saveCharacter(character)
                Toast.makeText(context, "Character created succesfully!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(CharacterCreationFragmentDirections.actionCharacterCreationFragmentToHomepageFragment())
            }
            catch (e: NumberFormatException) {
                Toast.makeText(context, "Make sure that the fields are correctly filled!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
