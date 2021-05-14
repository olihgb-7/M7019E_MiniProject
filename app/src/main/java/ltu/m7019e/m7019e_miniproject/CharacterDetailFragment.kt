package ltu.m7019e.m7019e_miniproject

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabase
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterDetailBinding
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.viewmodel.CharacterDetailViewModel

class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterDetailViewModel
    private lateinit var viewModelFactory: CharacterDetailViewModel.Factory

    private lateinit var characterDatabaseDao: CharacterDatabaseDao

    private lateinit var character: Character

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterDetailBinding.inflate(inflater)

        character = CharacterDetailFragmentArgs.fromBundle(requireArguments()).character
        binding.character = character

        val application = requireNotNull(this.activity).application
        characterDatabaseDao = CharacterDatabase.getInstance(application).characterDatabaseDao

        viewModelFactory = CharacterDetailViewModel.Factory(characterDatabaseDao, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterDetailViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterDetailBack.setOnClickListener {
            findNavController().navigate(CharacterDetailFragmentDirections.actionCharacterDetailFragmentToCharacterSelectionFragment())
        }

        binding.characterDelete.setOnClickListener {

            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setCancelable(true)
            builder.setTitle("Delete ${character.name}?")
            builder.setMessage("This action will delete this character and this action can not be undone. Are you sure you want to delete ${character.name}?")
            builder.setPositiveButton(
                    "Confirm",
                    DialogInterface.OnClickListener { dialog, which ->
                        viewModel.deleteCharacter(character)
                        Toast.makeText(context, "Character deleted!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(CharacterDetailFragmentDirections.actionCharacterDetailFragmentToCharacterSelectionFragment())
                    })
            builder.setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialog, which -> })

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}