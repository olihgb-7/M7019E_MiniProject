package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.adapter.CharacterClickListener
import ltu.m7019e.m7019e_miniproject.adapter.CharacterSelectionAdapter
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabase
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.databinding.FragmentCharacterSelectionBinding
import ltu.m7019e.m7019e_miniproject.viewmodel.CharacterSelectionViewModel

class CharacterSelectionFragment : Fragment() {

    private var _binding: FragmentCharacterSelectionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterSelectionViewModel
    private lateinit var viewModelFactory: CharacterSelectionViewModel.Factory

    private lateinit var characterDatabaseDao: CharacterDatabaseDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterSelectionBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application
        characterDatabaseDao = CharacterDatabase.getInstance(application).characterDatabaseDao

        viewModelFactory = CharacterSelectionViewModel.Factory(characterDatabaseDao, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterSelectionViewModel::class.java)


        val characterSelectionAdapter = CharacterSelectionAdapter(
                CharacterClickListener { character ->
                    viewModel.onCharacterItemClicked(character)
                }
        )
        binding.characterSelectionRv.adapter = characterSelectionAdapter
        viewModel.characterList.observe(viewLifecycleOwner, { characterList ->
            characterList?.let {
                characterSelectionAdapter.submitList(characterList)
            }
        })

        viewModel.navigateToCharacterDetails.observe(viewLifecycleOwner, { character ->
            character?.let {
                this.findNavController().navigate(
                        CharacterSelectionFragmentDirections.actionCharacterSelectionFragmentToCharacterDetailFragment(character)
                )
                viewModel.onCharacterDetailsNavigated()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characterSelectionBack.setOnClickListener {
            findNavController().navigate(CharacterSelectionFragmentDirections.actionCharacterSelectionFragmentToHomepageFragment())
        }
    }
}